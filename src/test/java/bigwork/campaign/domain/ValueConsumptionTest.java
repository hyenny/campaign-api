package bigwork.campaign.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class ValueConsumptionTest {

    private static final LocalDateTime START_DATE = LocalDateTime.of(2021, 11, 1, 12, 30);
    private static final LocalDateTime END_DATE = START_DATE.plusDays(30);

    @DisplayName("[필수값] 제목 누락")
    @Test
    void 제목_NULL_체크() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ValueConsumption valueConsumption = ValueConsumption.builder()
                    .startDate(START_DATE)
                    .endDate(END_DATE)
                    .notice("ONLY 빅워크 유저를 위한 가치소비 프로모션")
                    .imagePath("/images/test.jpg")
                    .build();
        });

        Assertions.assertEquals("제목이 없습니다.", exception.getMessage());
    }

    @DisplayName("[필수값] 상세이미지 누락")
    @Test
    void 상세이미지_NULL_체크() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ValueConsumption valueConsumption = ValueConsumption.builder()
                    .startDate(START_DATE)
                    .endDate(END_DATE)
                    .title("반려견을 위한 진짜 음식")
                    .notice("ONLY 빅워크 유저를 위한 가치소비 프로모션")
                    .build();
        });

        Assertions.assertEquals("상세 이미지가 없습니다.", exception.getMessage());
    }

    @DisplayName("[필수값] 유의사항 누락")
    @Test
    void 유의사항_NULL_체크() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ValueConsumption valueConsumption = ValueConsumption.builder()
                    .startDate(START_DATE)
                    .endDate(END_DATE)
                    .title("반려견을 위한 진짜 음식")
                    .imagePath("/images/test.jpg")
                    .build();
        });

        Assertions.assertEquals("유의사항이 없습니다.", exception.getMessage());
    }

}