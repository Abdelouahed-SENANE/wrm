package ma.youcode.wrm.dto.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public record WaitingListResponseDTO(
        LocalDateTime date,
        int capacity,
        String algorithmType,
        String algorithmMode,
        List<VisitResponseDTO> visitDTOs
) implements Serializable {

}
