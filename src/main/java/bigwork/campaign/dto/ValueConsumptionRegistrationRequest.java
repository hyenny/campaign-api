package bigwork.campaign.dto;

import bigwork.campaign.domain.Campaign;
import bigwork.campaign.domain.CampaignAdditionalService;
import bigwork.campaign.domain.CampaignService;
import bigwork.campaign.domain.ValueConsumption;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ValueConsumptionRegistrationRequest {

    @Size(max=13)
    @NotBlank(message = "[제목]을 입력해 주세요")
    private String title;

    @Size(max=10)
    @NotBlank(message = "[개설자]을 입력해 주세요")
    private String beneficiary;

    @NotNull(message = "[시작일]을 입력해 주세요")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDate;

    @NotNull(message = "[종료일]을 입력해 주세요")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDate;

    @NotNull(message = "[상세이미지]을 입력해 주세요")
    private MultipartFile detailImage;

    @NotNull(message = "[배너이미지]을 입력해 주세요")
    private MultipartFile bannerImage;

    private String purchaseUrl;

    private String reward;

    @Size(max=200)
    private String notice;

    @Size(max=200)
    private String howToPractice;

    public Campaign toEntityCampaign(CampaignAdditionalService campaignAdditionalService, String bannerImagePath) {
        return Campaign.builder()
                .name(this.title + " 가치소비")
                .beneficiary(this.beneficiary)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .bannerImagePath(bannerImagePath)
                .campaignAdditionalService(campaignAdditionalService)
                .build();
    }

    public ValueConsumption toEntityValueConsumption(CampaignService campaignService, String detailImagePath) {
        return ValueConsumption.builder()
                .title(this.title)
                .notice(this.notice)
                .howToPractice(this.howToPractice)
                .reward(this.reward)
                .purchaseUrl(this.purchaseUrl)
                .imagePath(detailImagePath)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .campaignService(campaignService)
                .build();
    }

}