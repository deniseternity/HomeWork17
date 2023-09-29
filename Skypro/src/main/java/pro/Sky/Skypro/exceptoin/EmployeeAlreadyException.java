package pro.Sky.Skypro.exceptoin;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import pro.Sky.Skypro.model.Employee;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyException extends RuntimeException {
    public EmployeeAlreadyException() {
    }

    public EmployeeAlreadyException(String message) {
        super(message);
    }

    public EmployeeAlreadyException(String message, Throwable cause) {
        super(message, cause);
    }
}
