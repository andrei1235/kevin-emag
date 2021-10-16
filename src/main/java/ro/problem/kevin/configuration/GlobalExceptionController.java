package ro.problem.kevin.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionController {

    private static final String GENERAL_ERROR_MESSAGE = "The server could not process your request. Please contact your Administrator if the issue persists.";

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(final Exception exception) {
        log.error("[handleException] - Handle exception with message " + exception.getMessage(), exception);

        return ResponseEntity.badRequest().body(GENERAL_ERROR_MESSAGE);
    }

}
