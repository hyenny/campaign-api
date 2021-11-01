package bigwork.campaign.service;

import bigwork.campaign.dto.UploadImagePath;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileUploadService {

    @Value("${app.upload.dir:${user.home}}")
    private String baseDir;

    public UploadImagePath uploadImages(MultipartFile banner, MultipartFile detail) {
        try {
            validateFileName(StringUtils.cleanPath(banner.getOriginalFilename()), StringUtils.cleanPath(detail.getOriginalFilename()));

            Path bannerCopy = Paths.get(baseDir + File.separator + getUUIDFilename(banner.getOriginalFilename()));
            Path detailCopy = Paths.get(baseDir + File.separator + getUUIDFilename(detail.getOriginalFilename()));

            Files.copy(banner.getInputStream(), bannerCopy);
            Files.copy(detail.getInputStream(), detailCopy);

            return new UploadImagePath(bannerCopy.toString(), detailCopy.toString());
        } catch (IOException e) {
            throw new RuntimeException("이미지 업로드가 실패했습니다.");
        }
    }

    private void validateFileName(String... originalFilenames) throws FileUploadException {
        for (String originalFilename : originalFilenames) {
            if (originalFilename.contains(".."))
                throw new FileUploadException("파일명에 부적합 문자가 포함되어 있습니다. " + originalFilename);
        }
    }

    private String getUUIDFilename(String originalFilename) {
        return UUID.randomUUID() + "_" + originalFilename;
    }
}
