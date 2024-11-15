package ma.youcode.wrm.dto.response.visitor;

import java.io.Serializable;
import java.util.List;

public record VisitorEmbeddedDTO(
        Long id,
        String firstName,
        String lastName
) implements Serializable {
}
