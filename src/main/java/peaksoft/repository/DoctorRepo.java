package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
}
