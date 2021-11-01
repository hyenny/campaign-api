package bigwork.campaign.error;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    // Common
    INVALID_INPUT_VALUE(400, "C001", "유효하지 않은 입력값입니다."),

    // File
    INVALID_FILE_NAME(400, "F001", "부적합한 파일명입니다."),
    FAILED_FILE_UPLOAD(500, "F002", "파일 업로드가 실패했습니다.");

    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return this.message;
    }

}
