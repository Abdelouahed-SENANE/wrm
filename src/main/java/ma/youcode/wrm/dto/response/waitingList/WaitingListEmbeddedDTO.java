package ma.youcode.wrm.dto.response.waitingList;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record WaitingListEmbeddedDTO(
        LocalDateTime date,
        int capacity,
        String algorithm
) implements Serializable {

}
