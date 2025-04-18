package ma.emsi.p2.services;


import ma.emsi.p2.entities.Admin;
import ma.emsi.p2.entities.Organization;
import ma.emsi.p2.exception.ResourceNotFoundException;
import ma.emsi.p2.exception.ValidationException;
import ma.emsi.p2.repositories.OrganizationRepository;
import ma.emsi.p2.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;

    public OrganizationService(OrganizationRepository organizationRepository, UserRepository userRepository) {
        this.organizationRepository = organizationRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Organization createOrganization(Organization organization, Long adminUserId) {
        // Validation
        if (organizationRepository.existsByTaxIdentificationNumber(organization.getTaxIdentificationNumber())) {
            throw new ValidationException("Tax Identification Number already exists");
        }

        // Associer l'admin
        userRepository.findById(adminUserId).ifPresentOrElse(
                user -> organization.setAdminUser(user),
                () -> { throw new ResourceNotFoundException("User not found with id: " + adminUserId); }
        );

        return organizationRepository.save(organization);
    }

    @Transactional(readOnly = true)
    public Page<Organization> getAllOrganizations(Pageable pageable) {
        return organizationRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Page<Organization> getValidatedOrganizations(Pageable pageable) {
        return organizationRepository.findByIsValidated(true, pageable);
    }

    @Transactional(readOnly = true)
    public Page<Organization> getPendingOrganizations(Pageable pageable) {
        return organizationRepository.findByIsValidated(false, pageable);
    }

    @Transactional(readOnly = true)
    public Organization getOrganizationById(Long id) {
        return organizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organization not found with id: " + id));
    }

    @Transactional
    public Organization updateOrganization(Long id, Organization organizationDetails) {
        Organization organization = getOrganizationById(id);

        organization.setName(organizationDetails.getName());
        organization.setLegalAddress(organizationDetails.getLegalAddress());
        organization.setDescription(organizationDetails.getDescription());
        organization.setContactEmail(organizationDetails.getContactEmail());
        organization.setContactPhone(organizationDetails.getContactPhone());
        organization.setLogoUrl(organizationDetails.getLogoUrl());

        return organizationRepository.save(organization);
    }

    @Transactional
    public void deleteOrganization(Long id) {
        Organization organization = getOrganizationById(id);
        organizationRepository.delete(organization);
    }

    @Transactional
    public Organization validateOrganization(Long id, Long adminId) {
        Organization organization = getOrganizationById(id);
        organization.setValidated(true);
        organization.setValidatedBy((Admin) userRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id: " + adminId)));
        return organizationRepository.save(organization);
    }


}