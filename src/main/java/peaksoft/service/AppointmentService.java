package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.entity.Appointment;

import java.util.List;

@Service
public interface AppointmentService {
    void saveAppointment(Long hospitalId, Appointment appointment);


    Appointment getAppointmentById(Long id);


    List<Appointment> getAllAppointment(Long id);


    void updateAppointment(Long id, Appointment appointment);


    void removeAppointmentById(Long id,Long hospitalId);

}
