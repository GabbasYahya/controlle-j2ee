package ma.emsi.p2.controllers;


import ma.emsi.p2.entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import ma.emsi.p2.DTOs.DonationDTO;
import ma.emsi.p2.entities.Campaign;
import ma.emsi.p2.entities.Donation;
import ma.emsi.p2.repositories.CampaignRepository;
import ma.emsi.p2.repositories.DonationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/campagnes")
public class DonationController {

    private final CampaignRepository campaignRepository;
    private final DonationRepository donationRepository;

    public DonationController(CampaignRepository campaignRepository, DonationRepository donationRepository) {
        this.campaignRepository = campaignRepository;
        this.donationRepository = donationRepository;
    }

    @PostMapping("/{id}/dons")
    public ResponseEntity<String> createDonation(@PathVariable Long id, @RequestBody DonationDTO donationDTO) {
        Optional<Campaign> campaignOptional = campaignRepository.findById(id);

        if (campaignOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Campaign not found");
        }

        Campaign campaign = campaignOptional.get();
        Donation donation = new Donation();
        donation.setCampaign(campaign);
        donation.setDonorName(donationDTO.getDonorName());
        donation.setAmount(donationDTO.getAmount());
        donation.setDate(donationDTO.getDate());



        donationRepository.save(donation);
        campaignRepository.save(campaign);

        return ResponseEntity.status(HttpStatus.CREATED).body("Donation created successfully");
    }
}
