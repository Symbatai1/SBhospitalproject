package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {
}
