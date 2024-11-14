package ma.youcode.wrm.dto.request;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

public record WaitingListRequestDTO(
        @NotNull
        LocalDateTime date,
        int capacity,
        String algorithmType,
        String algorithmMode
) implements Serializable {
}
