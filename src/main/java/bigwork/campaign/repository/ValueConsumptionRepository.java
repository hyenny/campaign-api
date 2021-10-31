package bigwork.campaign.repository;


import bigwork.campaign.domain.ValueConsumption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValueConsumptionRepository extends JpaRepository<ValueConsumption, Long> {
}
