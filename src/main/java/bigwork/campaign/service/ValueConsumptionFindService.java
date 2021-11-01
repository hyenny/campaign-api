package bigwork.campaign.service;

import bigwork.campaign.domain.ValueConsumption;
import bigwork.campaign.repository.ValueConsumptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ValueConsumptionFindService {

    private final ValueConsumptionRepository valueConsumptionRepository;

    public List<ValueConsumption> findList() {
        return valueConsumptionRepository.findAll();
    }

    public ValueConsumption find(Long id) {
        return valueConsumptionRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 가치소비 id 입니다."));
    }
}
