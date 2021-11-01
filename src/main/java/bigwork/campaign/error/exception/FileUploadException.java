package bigwork.campaign.error.exception;

import bigwork.campaign.error.ErrorCode;

public class FileUploadException extends RuntimeException {
    private ErrorCode errorCode;

    public FileUploadException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public FileUploadException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
