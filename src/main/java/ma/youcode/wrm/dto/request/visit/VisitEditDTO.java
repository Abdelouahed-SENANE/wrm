package ma.youcode.wrm.dto.request.visit;

import java.io.Serializable;
import java.time.LocalTime;

public record VisitEditDTO(
        LocalTime endTime,
        LocalTime startTime
) implements Serializable {
}
