package ma.youcode.wrm.dto.response.visitor;

import ma.youcode.wrm.dto.response.visit.VisitEmbeddedDTO;
import ma.youcode.wrm.dto.response.waitingList.WaitingListEmbeddedDTO;
import ma.youcode.wrm.entities.Visit;
import ma.youcode.wrm.enums.VisitStatus;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

public record VisitorResponseDTO(
        Long id,
        String firstName,
        String lastName,
        List<VisitEmbeddedDTO> visits
)implements Serializable {


}
