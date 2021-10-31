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
@Table(name = "value_consumption_commerce")
@Entity
public class ValueConsumption {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name="end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name="title", nullable = false, length = 100)
    private String title;

    @Column(name="notice", nullable = false, length = 1000)
    private String notice;

    @Column(name="how_to_practice", length = 1000)
    private String howToPractice;

    @Column(name="reward", length = 100)
    private String reward;

    @Column(name="purchase_url", length = 100)
    private String purchaseUrl;

    @Column(name="image_path", nullable = false)
    private String imagePath;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @JsonIgnore
    @JoinColumn(name = "service_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CampaignService campaignService;

    @Builder
    public ValueConsumption(LocalDateTime startDate, LocalDateTime endDate, String title, String notice, String howToPractice, String reward, String purchaseUrl, String imagePath, LocalDateTime createdAt, CampaignService campaignService) {
        Assert.hasText(title, "제목이 없습니다.");
        Assert.hasText(imagePath, "상세 이미지가 없습니다.");
        Assert.hasText(notice, "유의사항이 없습니다.");

        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.notice = notice;
        this.howToPractice = howToPractice;
        this.reward = reward;
        this.purchaseUrl = purchaseUrl;
        this.imagePath = imagePath;
        this.createdAt = LocalDateTime.now();
        this.campaignService = campaignService;
    }

}
