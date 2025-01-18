package bt.ufba.tomorrow.todoProject.api.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex){
        StringBuilder message = new StringBuilder("Erro(s) de validação: ");
        ex.getBindingResult().getAllErrors().forEach( error ->{
            message.append(error.getDefaultMessage()).append("; ");
        });  
        Map<String, Object> body = new HashMap<>();
        body.put("status",HttpStatus.BAD_REQUEST.value());
        body.put("error", "Problema nos parâmetros enviados!");
        body.put("message", message.toString().trim());
        body.put("timestamp",LocalDateTime.now());
        return new  ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handlerDataIntegrityViolationException(DataIntegrityViolationException ex){
        StringBuilder message = new StringBuilder("Erro de violação de integridade.");
        message.append(ex.getMessage());
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Problema nos parâmetro enviados!");
        body.put("message", message.toString().trim());
        body.put("timestamp", LocalDateTime.now());
        
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
