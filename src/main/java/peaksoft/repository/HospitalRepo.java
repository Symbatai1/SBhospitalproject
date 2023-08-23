package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Hospital;
@Repository
public interface HospitalRepo extends JpaRepository<Hospital,Long> {
}
