package bigwork.campaign.api;

import bigwork.campaign.dto.ValueConsumptionRegistrationRequest;
import bigwork.campaign.dto.ValueConsumptionRegistrationResponse;
import bigwork.campaign.service.ValueConsumptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/value-consumptions")
public class ValueConsumptionApi {

    private final ValueConsumptionService valueConsumptionService;

    @PostMapping
    public ResponseEntity<ValueConsumptionRegistrationResponse> register(@Valid @ModelAttribute ValueConsumptionRegistrationRequest request) {
        return new ResponseEntity<>(valueConsumptionService.register(request), HttpStatus.CREATED);
    }

}
