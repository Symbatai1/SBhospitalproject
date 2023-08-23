package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Department {
    @Id
    @SequenceGenerator(name = "user_id_gen", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "user_id_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "department",cascade = {DETACH, REFRESH, MERGE, DETACH})
    private List<Doctor> doctors;

    @ManyToOne(cascade = ALL,fetch = FetchType.EAGER)
    private Hospital hospital;


    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);

    }


}
