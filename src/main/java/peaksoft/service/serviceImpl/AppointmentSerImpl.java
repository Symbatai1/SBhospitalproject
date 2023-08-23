package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Appointment;
import peaksoft.entity.Hospital;
import peaksoft.repository.AppointmentRepo;
import peaksoft.service.*;

import java.io.IOException;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor

public class AppointmentSerImpl implements AppointmentService {

    private final AppointmentRepo appointmentRepo;
    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final HospitalService hospitalService;
    private final DoctorService doctorService;
    private final DepartmentService departmentService;

    @Override
    public void saveAppointment(Long hospitalId, Appointment appointment) {
        try {
            Hospital hospital = hospitalService.getHospitalById(hospitalId);
            Appointment newAppointment = new Appointment();
            newAppointment.setDate(appointment.getDate());
            newAppointment.setPatient(patientService.getPatientById(appointment.getPatientId()));
            newAppointment.setDoctor(doctorService.getDoctorById(appointment.getDoctorId()));
            newAppointment.setDepartment(departmentService.getDepartmentById(appointment.getDepartmentId()));
            hospital.addAppointment(newAppointment);
            appointmentRepo.save(newAppointment);

            int d = appointment.getDate().getYear();
            if (d <= 23){
                throw new IOException("You cannot register!");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepo.findById(id).get(); //.orElseThrow(()->new NoSuchElementException());
    }

    @Override
    public List<Appointment> getAllAppointment(Long id) {
        return appointmentRepo.findAll();
    }

    @Override
    public void updateAppointment(Long id, Appointment appointment) {
        Appointment oldAppointment = appointmentRepo.findById(id).get();
        oldAppointment.setDate(appointment.getDate());
        appointmentRepo.save(oldAppointment);

    }

    @Override
    public void removeAppointmentById(Long id, Long hospitalId) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        hospitalService.getHospitalById(hospitalId).getAppointments().remove(appointment);
        appointment.getDoctor().getAppointments().remove(appointment);
        appointment.getPatient().getAppointments().remove(appointment);
        appointmentService.removeAppointmentById(id, hospitalId);
    }
}












