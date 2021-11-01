package bigwork.campaign.service;

import bigwork.campaign.domain.CampaignService;
import bigwork.campaign.domain.CampaignType;
import bigwork.campaign.repository.CampaignServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CampaignServiceFindService {

    private final CampaignServiceRepository campaignServiceRepository;

    /**
     * 가치소비 타입의 CampaignService 객체를 가져온다.
     */
    public CampaignService findValueConsumptionType() {
        return campaignServiceRepository
                .findByType(CampaignType.VALUE_CONSUMPTION)
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 타입입니다."));
    }

}
