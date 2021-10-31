package bigwork.campaign.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "campaign")
@Entity
public class Campaign {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "beneficiary", nullable = false)
    private String beneficiary;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "banner_image_path")
    private String bannerImagePath;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @JsonIgnore
    @JoinColumn(name="additional_service_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CampaignAdditionalService campaignAdditionalService;

    @Builder
    public Campaign(String name, String beneficiary, LocalDateTime startDate, LocalDateTime endDate, String bannerImagePath, LocalDateTime createdAt, CampaignAdditionalService campaignAdditionalService) {
        Assert.hasText(beneficiary, "개설자명이 없습니다.");
        Assert.hasText(name, "캠페인 이름이 없습니다.");

        this.name = name;
        this.beneficiary = beneficiary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bannerImagePath = bannerImagePath;
        this.createdAt = LocalDateTime.now();
        this.campaignAdditionalService = campaignAdditionalService;
    }
}
