package bigwork.campaign.service;

import bigwork.campaign.domain.Campaign;
import bigwork.campaign.domain.CampaignAdditionalService;
import bigwork.campaign.domain.CampaignService;
import bigwork.campaign.domain.ValueConsumption;
import bigwork.campaign.dto.UploadImagePath;
import bigwork.campaign.dto.ValueConsumptionRegistrationRequest;
import bigwork.campaign.dto.ValueConsumptionRegistrationResponse;
import bigwork.campaign.repository.CampaignAdditionalServiceRepository;
import bigwork.campaign.repository.CampaignRepository;
import bigwork.campaign.repository.ValueConsumptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ValueConsumptionService {
    private final CampaignRepository campaignRepository;
    private final ValueConsumptionRepository valueConsumptionRepository;
    private final CampaignAdditionalServiceRepository campaignAdditionalServiceRepository;
    private final CampaignServiceFindService campaignServiceFindService;
    private final FileUploadService fileUploadService;

    @Transactional
    public ValueConsumptionRegistrationResponse register(ValueConsumptionRegistrationRequest request) {
        // 이미지 저장
        UploadImagePath uploadImagePath = fileUploadService.uploadImages(request.getBannerImage(), request.getDetailImage());

        // 캠페인서비스(가치소비) 조회
        CampaignService campaignService = campaignServiceFindService.findValueConsumptionType();

        // 캠페인 (-> 캠페인추가서비스 -> 캠페인서비스)
        Campaign campaign = request.toEntityCampaign(campaignAdditionalServiceRepository.save(new CampaignAdditionalService(campaignService)), uploadImagePath.getBannerImagePath());
        campaignRepository.save(campaign);

        // 가치소비 (-> 캠페인서비스)
        ValueConsumption valueConsumption = request.toEntityValueConsumption(campaignService, uploadImagePath.getDetailImagePath());
        valueConsumptionRepository.save(valueConsumption);

        return ValueConsumptionRegistrationResponse.of(campaign, valueConsumption);
    }

}
