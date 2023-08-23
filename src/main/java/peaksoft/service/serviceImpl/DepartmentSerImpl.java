package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Department;
import peaksoft.entity.Doctor;
import peaksoft.repository.DepartmentRepo;
import peaksoft.repository.DoctorRepo;
import peaksoft.service.DepartmentService;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor

public class DepartmentSerImpl implements DepartmentService {

    private final DepartmentRepo departmentRepo;

    private final DepartmentService departmentService;

    private final DoctorRepo doctorRepo;
    @Override
    public void saveDepartment(Long hospitalId, Department department) {
        departmentRepo.findById(hospitalId);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepo.findById(id).get();
    }

    @Override
    public List<Department> getAllDepartment(Long id) {
        return departmentRepo.findAll();

    }

    @Override
    public void updateDepartment(Long id, Department department) {
        Department oldDepartment = departmentService.getDepartmentById(id);
        oldDepartment.setName(department.getName());
        departmentRepo.save(oldDepartment);

    }

    @Override
    public void removeDepartmentById(Long id) {
        departmentRepo.deleteById(id);
    }

    @Override
    public void assignDoctor(Long doctorId, Long departmentId) {
        try {
            departmentRepo.findById(departmentId).get();
            Department department = new Department();
            doctorRepo.findById(doctorId);
            Doctor doctor = new Doctor();

            if (department.getId() != null) {
                for (Doctor d : department.getDoctors()) {
                    if (Objects.equals(d.getId(), departmentId)) {
                        throw new IOException("This doctor already exists!");
                    }

                }
                doctor.addDepartment(department);
                department.addDoctor(doctor);
                doctorRepo.save(doctor);
                departmentRepo.save(department);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}