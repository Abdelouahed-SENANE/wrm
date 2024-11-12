package ma.youcode.wrm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum VisitStatus {
    PENDING("Pending"),
    COMPLETED("Completed"),
    IN_PROGRESS("In progress"),
    CANCELLED("Cancelled");

    private final String desc;

}
