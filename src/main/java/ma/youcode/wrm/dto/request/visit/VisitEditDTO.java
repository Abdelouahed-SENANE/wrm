package ma.youcode.wrm.dto.request.visit;

import ma.youcode.wrm.enums.VisitStatus;

import java.io.Serializable;
import java.time.LocalTime;

public record VisitEditDTO(
        LocalTime endTime,
        LocalTime startTime,
        VisitStatus status
) implements Serializable {
}
