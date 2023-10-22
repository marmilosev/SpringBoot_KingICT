package hr.kingict.springbootakademija2023.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandlerController {
    @ExceptionHandler
    public ResponseEntity<List<String>> handleException(MethodArgumentNotValidException exception){
        return ResponseEntity
                .badRequest()
                .body(exception.getAllErrors()
                        .stream()
                        .map(ObjectError::toString)
                        .toList());

    }

}
