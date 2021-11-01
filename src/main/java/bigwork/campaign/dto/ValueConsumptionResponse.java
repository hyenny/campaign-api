package bigwork.campaign.dto;

import bigwork.campaign.domain.ValueConsumption;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValueConsumptionResponse {
    private ValueConsumption valueConsumption;

    @Builder
    public ValueConsumptionResponse(ValueConsumption valueConsumption) {
        this.valueConsumption = valueConsumption;
    }

    public static ValueConsumptionResponse of(ValueConsumption valueConsumption) {
        return new ValueConsumptionResponse(valueConsumption);
    }

    public static List<ValueConsumptionResponse> toList(List<ValueConsumption> valueConsumptions) {
        return valueConsumptions.stream().map(valueConsumption -> ValueConsumptionResponse.of(valueConsumption)).collect(Collectors.toList());
    }
}
