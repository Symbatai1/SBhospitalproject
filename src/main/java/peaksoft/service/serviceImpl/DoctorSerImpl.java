package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Doctor;
import peaksoft.entity.Hospital;
import peaksoft.repository.DoctorRepo;
import peaksoft.service.DoctorService;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class DoctorSerImpl implements DoctorService {

    private final DoctorRepo doctorRepo;

    private final DoctorService doctorService;

    @Override
    public void saveDoctor(Long hospitalId, Doctor doctor) {
        doctorRepo.findById(hospitalId);
        Hospital hospital = new Hospital();
        hospital.setDoctor(doctor);
        doctor.setHospital(hospital);
        doctorRepo.save(doctor);
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepo.findById(id).get();
    }

    @Override
    public List<Doctor> getAllDoctor(Long id) {
        return doctorRepo.findAll();
    }

    @Override
    public void updateDoctor(Long id, Doctor doctor) {
        Doctor oldDoctor = doctorService.getDoctorById(id);
        oldDoctor.setFirstName(doctor.getFirstName());
        oldDoctor.setLastName(doctor.getLastName());
        oldDoctor.setEmail(doctor.getEmail());
        oldDoctor.setPosition(doctor.getPosition());
        doctorRepo.save(doctor);

    }

    @Override
    public void removeDoctorById(Long id) {
        doctorRepo.deleteById(id);
    }
}
