package ma.emsi.p2.repositories;



import ma.emsi.p2.entities.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    // Trouver une organisation par son ID
    Optional<Organization> findById(Long id);

    // Trouver toutes les organisations avec pagination
    Page<Organization> findAll(Pageable pageable);

    // Trouver les organisations validées ou en attente
    Page<Organization> findByIsValidated(boolean isValidated, Pageable pageable);

    // Vérifier l'existence d'une organisation par son numéro d'identification fiscale
    boolean existsByTaxIdentificationNumber(String taxIdentificationNumber);

    // Trouver une organisation par son numéro d'identification fiscale
    Optional<Organization> findByTaxIdentificationNumber(String taxIdentificationNumber);

    // Recherche d'organisations par nom (insensible à la casse)
    List<Organization> findByNameContainingIgnoreCase(String name);
    // Trouver les organisations gérées par un administrateur spécifique
    List<Organization> findByAdminUser_Id(Long adminId);

    // Compter le nombre d'organisations validées ou non
    long countByIsValidated(boolean isValidated);


    // Trouver les organisations populaires (avec le plus de campagnes)

}