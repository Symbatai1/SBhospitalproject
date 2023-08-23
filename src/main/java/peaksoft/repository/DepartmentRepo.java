package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
