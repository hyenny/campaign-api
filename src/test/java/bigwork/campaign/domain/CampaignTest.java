package bigwork.campaign.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CampaignTest {
    private static final LocalDateTime START_DATE = LocalDateTime.of(2021, 11, 1, 12, 30);
    private static final LocalDateTime END_DATE = START_DATE.plusDays(30);

    @DisplayName("[필수값] 개설자명 누락")
    @Test
    void 개설자명_NULL_체크() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Campaign campaign = Campaign.builder()
                    .name("반려견을 위한 진짜 음식 가치소비")
                    .startDate(START_DATE)
                    .endDate(END_DATE)
                    .campaignAdditionalService(new CampaignAdditionalService(new CampaignService(CampaignType.VALUE_CONSUMPTION)))
                    .build();
        });

        assertEquals("개설자명이 없습니다.", exception.getMessage());
    }

    @DisplayName("[필수값] 캠페인명 누락")
    @Test
    void 캠페인명_NULL_체크() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Campaign campaign = Campaign.builder()
                    .beneficiary("어니스트밀")
                    .startDate(START_DATE)
                    .endDate(END_DATE)
                    .campaignAdditionalService(new CampaignAdditionalService(new CampaignService(CampaignType.VALUE_CONSUMPTION)))
                    .build();
        });

        assertEquals("캠페인 이름이 없습니다.", exception.getMessage());
    }

}