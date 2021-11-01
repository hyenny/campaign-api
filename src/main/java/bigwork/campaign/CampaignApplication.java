package bigwork.campaign;

import bigwork.campaign.domain.CampaignService;
import bigwork.campaign.domain.CampaignType;
import bigwork.campaign.repository.CampaignServiceRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CampaignApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampaignApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(CampaignServiceRepository campaignServiceRepository) {
        return args -> {
            // VALUE_CONSUMPTION 타입의 캠페인 서비스 데이터를 넣어준다.
            campaignServiceRepository.save(new CampaignService(CampaignType.VALUE_CONSUMPTION));
        };
    }

}
