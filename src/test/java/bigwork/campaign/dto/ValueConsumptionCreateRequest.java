package bigwork.campaign.dto;

import bigwork.campaign.domain.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ValueConsumptionCreateRequest {

    @Size(max=13)
    @NotBlank(message = "[제목]을 입력해 주세요")
    private String title;

    @Size(max=10)
    @NotBlank(message = "[개설자]을 입력해 주세요")
    private String beneficiary;

    @NotBlank(message = "[시작일]을 입력해 주세요")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDate;

    @NotBlank(message = "[종료일]을 입력해 주세요")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDate;

    @NotBlank(message = "[상세이미지]을 입력해 주세요")
    private String detailImagePath;

    @NotBlank(message = "[배너이미지]을 입력해 주세요")
    private String bannerImagePath;

    private String purchaseUrl;

    private String reward;

    @Size(max=200)
    private String notice;

    @Size(max=200)
    private String howToPractice;

    private static CampaignService createCampaignService() {
        return new CampaignService(CampaignType.VALUE_CONSUMPTION);
    }

    public Campaign toEntityCampaign() {
        return Campaign.builder()
                .name(this.title + " 가치소비")
                .beneficiary(this.beneficiary)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .bannerImagePath(this.bannerImagePath)
                .campaignAdditionalService(new CampaignAdditionalService(createCampaignService()))
                .build();
    }

    public ValueConsumption toEntityValueConsumption() {
        return ValueConsumption.builder()
                .title(this.title)
                .notice(this.notice)
                .howToPractice(this.howToPractice)
                .reward(this.reward)
                .purchaseUrl(this.purchaseUrl)
                .imagePath(this.detailImagePath)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .campaignService(createCampaignService())
                .build();
    }

}
