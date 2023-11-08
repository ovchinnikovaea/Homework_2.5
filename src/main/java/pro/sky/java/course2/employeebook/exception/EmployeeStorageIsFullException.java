package pro.sky.java.course2.employeebook.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String massege) {
        super(massege);
    }
}
