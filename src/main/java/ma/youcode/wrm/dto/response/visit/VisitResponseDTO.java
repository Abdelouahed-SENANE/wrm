package ma.youcode.wrm.dto.response.visit;

import com.fasterxml.jackson.annotation.JsonCreator;
import ma.youcode.wrm.dto.response.visitor.VisitorEmbeddedDTO;
import ma.youcode.wrm.dto.response.waitingList.WaitingListEmbeddedDTO;

import ma.youcode.wrm.enums.VisitStatus;

import java.time.LocalTime;

public record VisitResponseDTO(
        LocalTime arrivalTime,
        LocalTime startTime,
        LocalTime endTime,
        LocalTime estimatedProcessingTime,
        Integer priority,
        String status,
        WaitingListEmbeddedDTO waitingList,
        VisitorEmbeddedDTO visitor

) {
    public VisitResponseDTO(
            LocalTime arrivalTime,
            LocalTime startTime,
            LocalTime endTime,
            LocalTime estimatedProcessingTime,
            Integer priority,
            VisitStatus status,
            WaitingListEmbeddedDTO waitingList,
            VisitorEmbeddedDTO visitor
    ) {
        this(
                arrivalTime,
                startTime,
                endTime,
                estimatedProcessingTime,
                priority,
                status.getDesc(),
                waitingList,
                visitor
        );
    }

}
