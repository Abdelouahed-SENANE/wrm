package ma.youcode.wrm.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.youcode.wrm.common.BaseEntity;
import ma.youcode.wrm.enums.VisitStatus;

import java.time.LocalTime;

@Entity
@Table(name = "visits")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Visit extends BaseEntity {

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "visit_status")
    private VisitStatus status;

    @Column(name = "priority")
    private int priority;

    @Column(name = "estimated_processing_time")
    private LocalTime estimatedProcessingTime;

    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "waiting_list_id")
    private WaitingList waitingList;



}
