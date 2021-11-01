package bigwork.campaign.dto;

import lombok.Getter;
import org.springframework.util.Assert;

@Getter
public class UploadImagePath {

    private String bannerImagePath;
    private String detailImagePath;

    public UploadImagePath(String bannerImagePath, String detailImagePath) {
        Assert.hasText(bannerImagePath, "배너 이미지 경로가 없습니다.");
        Assert.hasText(detailImagePath, "상세 이미지 경로가 없습니다.");

        this.bannerImagePath = bannerImagePath;
        this.detailImagePath = detailImagePath;
    }
}
