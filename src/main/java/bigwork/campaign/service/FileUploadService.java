package bigwork.campaign.service;

import bigwork.campaign.dto.UploadImagePath;
import bigwork.campaign.error.ErrorCode;
import bigwork.campaign.error.exception.FileUploadException;
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
        String bannerImagePath = store(banner);
        String detailImagePath = store(detail);

        return new UploadImagePath(bannerImagePath, detailImagePath);
    }

    public String store(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        validateFileName(StringUtils.cleanPath(originalFilename));

        Path targetPath = Paths.get(baseDir + File.separator + getUUIDFilename(originalFilename));
        try {
            Files.copy(file.getInputStream(), targetPath);
        } catch (IOException e) {
            throw new FileUploadException(ErrorCode.FAILED_FILE_UPLOAD);
        }
        return targetPath.toString();
    }

    private void validateFileName(String originalFilename) {
        if (!StringUtils.hasText(originalFilename) || originalFilename.contains(".."))
            throw new FileUploadException(ErrorCode.INVALID_FILE_NAME);
    }

    private String getUUIDFilename(String originalFilename) {
        return UUID.randomUUID() + "_" + originalFilename;
    }
}
