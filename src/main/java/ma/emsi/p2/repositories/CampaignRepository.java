package ma.emsi.p2.repositories;

import ma.emsi.p2.projections.CampagneResume;
import ma.emsi.p2.entities.Campaign;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    @Query("SELECT c FROM Campaign c WHERE c.endDate > CURRENT_DATE")
    List<CampagneResume> findActiveCampaigns();
}