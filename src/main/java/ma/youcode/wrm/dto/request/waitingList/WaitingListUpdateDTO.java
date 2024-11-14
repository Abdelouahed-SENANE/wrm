package ma.youcode.wrm.dto.request.waitingList;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

public record WaitingListUpdateDTO(
        @NotNull LocalDateTime date,
        @NotNull int capacity,
        @NotEmpty String algorithm
) implements Serializable {
}
