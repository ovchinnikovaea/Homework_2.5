package pro.sky.java.course2.employeebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidateInputException extends RuntimeException {

    public InvalidateInputException() {
    }

    public InvalidateInputException(String message) {
        super(message);
    }

    public InvalidateInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidateInputException(Throwable cause) {
        super(cause);
    }

    public InvalidateInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
