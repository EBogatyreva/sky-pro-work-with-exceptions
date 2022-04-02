package pro.sky.skyproworkwithexceptions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class OverFlowException extends RuntimeException {//massive is full
    public OverFlowException() {
        super("Internal Server Error");
    }
}
