package ma.youcode.wrm.utils;

import ma.youcode.wrm.dto.ErrorDTO;
import ma.youcode.wrm.dto.PageDTO;
import ma.youcode.wrm.dto.SuccessDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public abstract class Response {

    public static ResponseEntity<SuccessDTO> success(int status, String message, String key, Page<?> items) {
        Map<String, Object> payload = new HashMap<>();
        payload.put(key, items.getContent());
        PageDTO pageDTO = new PageDTO(
                items.getTotalElements(),
                items.getTotalPages(),
                items.getSize(),
                items.getNumber() + 1,
                items.hasPrevious(),
                items.hasNext()
        );
        return ResponseEntity.status(status).body(new SuccessDTO(LocalDateTime.now() ,status, message, payload, pageDTO));
    }

    public static ResponseEntity<SuccessDTO> success(int status, String message, String key, Object value) {
        Map<String, Object> payload = new HashMap<>();
        payload.put(key, value);
        return ResponseEntity.status(status).body(new SuccessDTO(LocalDateTime.now() , status, message, payload, null));
    }

    public static ResponseEntity<SuccessDTO> success(int status, String message) {
        return ResponseEntity.status(status).body(new SuccessDTO(LocalDateTime.now() ,status, message, null, null));
    }

    public static ResponseEntity<ErrorDTO> error(int status, String message) {
        return ResponseEntity.status(status).body(new ErrorDTO(LocalDateTime.now() ,status, message, null));
    }

    public static ResponseEntity<ErrorDTO> error(int status, String message, Map<String, String> errors) {
        return ResponseEntity.status(status).body(new ErrorDTO(LocalDateTime.now() ,status, message, errors));
    }
}
