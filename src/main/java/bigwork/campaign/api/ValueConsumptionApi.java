package bigwork.campaign.api;

import bigwork.campaign.domain.ValueConsumption;
import bigwork.campaign.dto.ValueConsumptionRegistrationRequest;
import bigwork.campaign.dto.ValueConsumptionRegistrationResponse;
import bigwork.campaign.dto.ValueConsumptionResponse;
import bigwork.campaign.service.ValueConsumptionFindService;
import bigwork.campaign.service.ValueConsumptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/value-consumptions")
public class ValueConsumptionApi {

    private final ValueConsumptionService valueConsumptionService;
    private final ValueConsumptionFindService valueConsumptionFindService;

    @PostMapping
    public ResponseEntity<ValueConsumptionRegistrationResponse> register(@Valid @ModelAttribute ValueConsumptionRegistrationRequest request) {
        return new ResponseEntity<>(valueConsumptionService.register(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ValueConsumptionResponse>> findList() {
        List<ValueConsumption> findList = valueConsumptionFindService.findList();
        return new ResponseEntity<>(ValueConsumptionResponse.toList(findList), HttpStatus.OK);
    }

    @GetMapping("/{valueConsumptionId}")
    public ResponseEntity<ValueConsumptionResponse> find(@PathVariable Long valueConsumptionId) {
        ValueConsumption find = valueConsumptionFindService.find(valueConsumptionId);
        return new ResponseEntity<>(ValueConsumptionResponse.of(find), HttpStatus.OK);
    }

}
