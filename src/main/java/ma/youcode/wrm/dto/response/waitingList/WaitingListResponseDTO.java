package ma.youcode.wrm.dto.response.waitingList;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.youcode.wrm.dto.response.visit.VisitEmbeddedDTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record WaitingListResponseDTO(
        LocalDateTime date,
        int capacity,
        String algorithmType,
        String algorithmMode,
        List<VisitEmbeddedDTO> visits
) implements Serializable {

}
