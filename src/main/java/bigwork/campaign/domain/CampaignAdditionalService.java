package bigwork.campaign.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * event, sms 생략
 */
@Getter
@NoArgsConstructor
@Table(name = "campaign_additional_service")
@Entity
public class CampaignAdditionalService {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime createdAt;

    @JoinColumn(name = "service_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CampaignService campaignService;

    public CampaignAdditionalService(CampaignService campaignService) {
        this.createdAt = LocalDateTime.now();
        this.campaignService = campaignService;
    }
}
