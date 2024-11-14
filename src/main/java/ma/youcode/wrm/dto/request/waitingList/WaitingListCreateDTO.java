package ma.youcode.wrm.dto.request.waitingList;



import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

public record WaitingListCreateDTO(
        @NotNull
        LocalDateTime date,
        int capacity,
        String algorithm
) implements Serializable {
}
