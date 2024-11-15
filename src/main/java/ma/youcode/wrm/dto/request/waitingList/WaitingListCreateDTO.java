package ma.youcode.wrm.dto.request.waitingList;



import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

public record WaitingListCreateDTO(
        @NotNull
        LocalDateTime date,
        int capacity,
        String algorithm
) implements Serializable {

        @AssertTrue(message = "Date must be today or in the future")
        private boolean isDate(){
                return !date.isBefore(LocalDateTime.now());
        }

}
