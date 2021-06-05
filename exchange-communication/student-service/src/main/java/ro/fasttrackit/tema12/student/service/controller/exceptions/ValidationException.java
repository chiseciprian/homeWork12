package ro.fasttrackit.tema12.student.service.controller.exceptions;

public class ValidationException extends RuntimeException {
    public ValidationException(String msg) {
        super(msg);
    }
}
