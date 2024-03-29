package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "hospitals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Hospital {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "department_id_gen")
    @SequenceGenerator(name = "department_id_gen", sequenceName = "department_id_seq", allocationSize = 1)
    private Long id;

    private String name;

    private String address;

    private String image;

    @OneToMany(cascade = {ALL}, fetch = LAZY, mappedBy = "hospital")
    private List<Doctor> doctors;

    @OneToMany(mappedBy = "hospital", fetch = LAZY, cascade = ALL)
    private List<Patient> patients;

    @OneToMany(cascade = {ALL}, fetch = LAZY,mappedBy = "hospital")
    private List<Department>departments=new ArrayList<>();

    @OneToMany(cascade = {ALL}, fetch = LAZY)
    private List<Appointment> appointments;

    public Hospital(String name, String address, String image) {
        this.name = name;
        this.address = address;
        this.image = image;

    }

    public void setDepartment(Department department) {
        this.departments.add(department);

    }

    public void setDoctor(Doctor doctor) {
        this.doctors.add(doctor);

    }

    public void addAppointment(Appointment newAppointment) {
        this.appointments.add(newAppointment);

    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);

    }

    public void setPatient(Patient patient) {

        this.patients.add(patient);
    }
}
