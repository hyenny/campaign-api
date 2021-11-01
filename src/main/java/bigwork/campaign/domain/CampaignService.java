package bigwork.campaign.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table(name = "campaign_service")
@Entity
public class CampaignService {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", length = 20, nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private CampaignType type;

    @Column
    private LocalDateTime createdAt;

    public CampaignService(CampaignType type) {
        this.type = type;
        this.createdAt = LocalDateTime.now();
    }

}
