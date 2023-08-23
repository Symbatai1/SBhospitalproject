package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.entity.Department;

import java.util.List;

@Service
public  interface DepartmentService {
    public abstract void saveDepartment(Long hospitalId, Department department);


    public abstract Department getDepartmentById(Long id);


    public abstract List<Department> getAllDepartment(Long id);


    public abstract void updateDepartment(Long id, Department department);


    public abstract void removeDepartmentById(Long id);


    public abstract void assignDoctor(Long doctorId, Long departmentId);
}

