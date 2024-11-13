package ma.youcode.wrm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.youcode.wrm.common.BaseEntity;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "waiting_list")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WaitingList extends BaseEntity {

    @Column(name = "waiting_date")
    private LocalDateTime date;

    @Column(name = "algorithm_type")
    private String algorithm;

    @Column(name = "algorithm_mode")
    private String mode;

    @OneToMany(mappedBy = "waitingList" , fetch = FetchType.EAGER)
    private List<Visit> visits;

}
