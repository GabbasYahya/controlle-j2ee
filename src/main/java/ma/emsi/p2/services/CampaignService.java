package ma.emsi.p2.services;



import ma.emsi.p2.entities.Campaign;
import ma.emsi.p2.repositories.CampaignRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {
    private final CampaignRepository campaignRepository;

    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }


}