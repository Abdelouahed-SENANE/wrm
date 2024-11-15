package ma.youcode.wrm.exceptions;

import jakarta.persistence.EntityNotFoundException;
import ma.youcode.wrm.dto.ErrorDTO;
import ma.youcode.wrm.utils.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestControllerAdvice
public class HandlerException {
    private  final Logger logger = Logger.getLogger("HandlerException");
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGenericException(Exception e) {
        return Response.error(400 , e.getMessage() , null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationException(MethodArgumentNotValidException e) {
        Map<String , String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(),  fieldError.getDefaultMessage());
        });

        return Response.error(400 , "errors"  , errors);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleEntityNotFoundException(EntityNotFoundException ex) {
        return Response.error(404, ex.getMessage() , null);
    }
}
