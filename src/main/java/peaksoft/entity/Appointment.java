package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.*;
@Entity
@Table(name = "appointments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Appointment {
    @Id
    @SequenceGenerator(name = "user_id_gen", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "user_id_gen", strategy = GenerationType.SEQUENCE)

    private Long id;

    private LocalDate date;

    private String image;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {DETACH, REFRESH, PERSIST, MERGE,})
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {DETACH, PERSIST, MERGE, REFRESH})
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {DETACH, MERGE, PERSIST, REFRESH})
    private Department department;

    @Transient
    private Long doctorId;

    @Transient
    private Long departmentId;

    @Transient
    private Long patientId;

}
