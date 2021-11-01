package bigwork.campaign.dto;

import bigwork.campaign.domain.Campaign;
import bigwork.campaign.domain.ValueConsumption;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValueConsumptionRegistrationResponse {
    private Campaign campaign;
    private ValueConsumption valueConsumption;

    @Builder
    public ValueConsumptionRegistrationResponse(Campaign campaign, ValueConsumption valueConsumption) {
        this.campaign = campaign;
        this.valueConsumption = valueConsumption;
    }

    public static ValueConsumptionRegistrationResponse of(Campaign campaign, ValueConsumption valueConsumption) {
        return new ValueConsumptionRegistrationResponse(campaign, valueConsumption);
    }

}
