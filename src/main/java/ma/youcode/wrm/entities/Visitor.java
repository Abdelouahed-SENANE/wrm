package ma.youcode.wrm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.youcode.wrm.common.BaseEntity;

import java.util.List;

@Entity
@Table(name = "visitors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Visitor extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "visitor" , fetch = FetchType.EAGER)
    private List<Visit> visits;


}
