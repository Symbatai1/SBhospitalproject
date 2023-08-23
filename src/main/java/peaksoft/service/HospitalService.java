package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.entity.Hospital;

import java.util.List;

@Service
public interface HospitalService {
    void saveHospital(Hospital hospital);


    Hospital getHospitalById(Long id);


    List<Hospital> getAllHospital();


    void updateHospital(Long id,Hospital hospital);


    void removeHospitalById(Long hospitalId);
}
