package bigwork.campaign.dto;

import bigwork.campaign.domain.Campaign;
import bigwork.campaign.domain.ValueConsumption;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValueConsumptionCreateResponse {
    private Campaign campaign;
    private ValueConsumption valueConsumption;

    @Builder
    public ValueConsumptionCreateResponse(Campaign campaign, ValueConsumption valueConsumption) {
        this.campaign = campaign;
        this.valueConsumption = valueConsumption;
    }

    public static ValueConsumptionCreateResponse of(Campaign campaign, ValueConsumption valueConsumption) {
        return new ValueConsumptionCreateResponse(campaign, valueConsumption);
    }

}
