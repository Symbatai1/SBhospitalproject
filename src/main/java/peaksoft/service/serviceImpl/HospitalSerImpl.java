package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entity.Hospital;
import peaksoft.repository.HospitalRepo;
import peaksoft.service.HospitalService;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class HospitalSerImpl implements HospitalService {
    private final HospitalRepo hospitalRepo;

    private final HospitalService hospitalService;

    @Override
    public void saveHospital(Hospital hospital) {
        hospitalRepo.save(hospital);
    }

    @Override
    public Hospital getHospitalById(Long id) {
        return hospitalRepo.findById(id).get();
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalRepo.findAll();
    }

    @Override
    public void updateHospital(Long id, Hospital hospital) {
        Hospital oldHospital = hospitalService.getHospitalById(id);
        oldHospital.setName(hospital.getName());
        oldHospital.setAddress(hospital.getAddress());
        oldHospital.setImage(hospital.getImage());
        hospitalRepo.save(oldHospital);

    }

    @Override
    public void removeHospitalById(Long hospitalId) {
        hospitalRepo.deleteById(hospitalId);

    }
}
