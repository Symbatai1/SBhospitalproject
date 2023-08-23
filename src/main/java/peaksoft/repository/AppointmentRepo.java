package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Appointment;
@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
}
