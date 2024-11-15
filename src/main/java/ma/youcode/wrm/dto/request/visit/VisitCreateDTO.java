package ma.youcode.wrm.dto.request.visit;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import ma.youcode.wrm.enums.VisitStatus;

import java.io.Serializable;
import java.time.LocalTime;

public record VisitCreateDTO(
        @NotNull
        LocalTime arrivalTime,
        LocalTime startTime,
        LocalTime endTime,
        LocalTime estimatedProcessingTime,
        @Min(0) @Max(255) Integer priority,
        VisitStatus status,
        @NotNull Long visitorId,
        @NotNull Long waitingListId

) implements Serializable {
        public VisitCreateDTO{status = VisitStatus.PENDING;}
}
