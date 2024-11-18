package ma.youcode.wrm.enums;

import lombok.Getter;

@Getter
public enum VisitStatus {
    PENDING("Pending"),
    COMPLETED("Completed"),
    IN_PROGRESS("In progress"),
    CANCELLED("Cancelled");

    private final String displayName;

    VisitStatus(String displayName) {
        this.displayName = displayName;
    }

}
