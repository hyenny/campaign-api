package bigwork.campaign.repository;

import bigwork.campaign.domain.CampaignService;
import bigwork.campaign.domain.CampaignType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CampaignServiceRepository extends JpaRepository<CampaignService, Long> {
    Optional<CampaignService> findByType(CampaignType type);
}
