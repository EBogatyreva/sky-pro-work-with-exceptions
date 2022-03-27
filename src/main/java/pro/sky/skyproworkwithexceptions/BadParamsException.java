package pro.sky.skyproworkwithexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class BadParamsException extends RuntimeException {

}
