package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "doctors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Doctor {
    @Id
    @SequenceGenerator(name = "user_id_gen", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "user_id_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "fisrt_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String email;

    private String position;

    @ManyToMany(mappedBy = "doctors", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Department> departments;

    @ManyToOne(cascade = CascadeType.ALL)
    private Hospital hospital;

    public void addDepartment(Department department) {
        this.departments.add(department);

    }

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Appointment> appointments;


    public void setDepartment(Department department) {
        this.departments.add(department);

    }
}
