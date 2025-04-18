package ma.emsi.p2.controllers;



import ma.emsi.p2.entities.Campaign;
import ma.emsi.p2.projections.CampagneResume;
import ma.emsi.p2.repositories.CampaignRepository;
import ma.emsi.p2.services.CampaignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController { ;


    private final CampaignRepository campaignRepository;

    public CampaignController(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @GetMapping("/actives")
    public List<CampagneResume> getActiveCampaigns() {
        return campaignRepository.findActiveCampaigns();
    }
}