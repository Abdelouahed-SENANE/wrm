package ma.youcode.wrm.dto.response.visit;

import ma.youcode.wrm.enums.VisitStatus;

import java.time.LocalTime;

public record VisitEmbeddedDTO(
        LocalTime arrivalTime,
        LocalTime startTime,
        LocalTime endTime,
        LocalTime estimatedProcessingTime,
        Integer priority,
        VisitStatus status
) {
}
