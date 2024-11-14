package ma.youcode.wrm.dto.request.visit;

import jakarta.validation.constraints.NotNull;
import ma.youcode.wrm.enums.VisitStatus;

import java.io.Serializable;
import java.time.LocalTime;

public record VisitUpdateDTO(
        @NotNull
        LocalTime arrivalTime,
        LocalTime startTime,
        LocalTime endTime,
        LocalTime estimatedProcessedTime,
        int priority,
        VisitStatus status,
        Long visitorId,
        Long waitingListId

) implements Serializable {

}
