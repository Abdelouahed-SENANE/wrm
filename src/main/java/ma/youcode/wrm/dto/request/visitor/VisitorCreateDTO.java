package ma.youcode.wrm.dto.request.visitor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import ma.youcode.wrm.enums.VisitStatus;

import java.io.Serializable;
import java.time.LocalTime;

public record VisitorCreateDTO(
        @NotEmpty
        String firstName,
        @NotEmpty
        String lastName
) implements Serializable {

}
