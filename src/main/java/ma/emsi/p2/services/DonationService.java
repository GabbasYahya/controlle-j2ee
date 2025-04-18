package ma.emsi.p2.services;




import ma.emsi.p2.DTOs.DonationDTO;
import ma.emsi.p2.entities.Campaign;
import ma.emsi.p2.entities.Donation;
import ma.emsi.p2.repositories.CampaignRepository;
import ma.emsi.p2.repositories.DonationRepository;
import org.springframework.stereotype.Service;

@Service
public class DonationService {
    private final DonationRepository donationRepository;
    private final CampaignRepository campaignRepository;

    public DonationService(DonationRepository donationRepository, CampaignRepository campaignRepository) {
        this.donationRepository = donationRepository;
        this.campaignRepository = campaignRepository;
    }

    public Donation saveDonation(DonationDTO donationDTO) {
        Campaign campaign = campaignRepository.findById(donationDTO.getId())
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        Donation donation = new Donation();
        donation.setCampaign(campaign);
        donation.setDonorName(donationDTO.getDonorName());
        donation.setAmount(donationDTO.getAmount());
        donation.setDate(donationDTO.getDate());

        return donationRepository.save(donation);
    }
}