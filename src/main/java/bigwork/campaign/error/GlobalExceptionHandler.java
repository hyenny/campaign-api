package bigwork.campaign.error;


import bigwork.campaign.error.exception.FileUploadException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 바인딩 에러 (@ModelAttribute)
     */
    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ErrorResponse> handleBindException(BindException e) {
        log.error("handleBindException", e);
        ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 파일 업로드 에러
     */
    @ExceptionHandler(FileUploadException.class)
    protected ResponseEntity<ErrorResponse> handleFileUploadExceptionn(FileUploadException e) {
        log.error("handleFileUploadException", e);
        ErrorResponse response = ErrorResponse.of(e.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

}
