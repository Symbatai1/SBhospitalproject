package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Hospital;
import peaksoft.entity.Patient;
import peaksoft.repository.PatientRepo;
import peaksoft.service.PatientService;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor

public class PatientSerImpl implements PatientService {
    private final PatientRepo patientRepo;

    private final PatientService patientService;
    @Override
    public void savePatient(Long hospitalId, Patient patient) {
        patientRepo.findById(hospitalId);
        Hospital hospital = new Hospital();
        hospital.setPatient(patient);
        patient.setHospital(hospital);
        patientRepo.save(patient);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepo.findById(id).get();
    }

    @Override
    public List<Patient> getAllPatient(Long id) {
        return patientRepo.findAll();
    }

    @Override
    public void updatePatient(Long id, Patient patient) {
        Patient oldPatient = patientService.getPatientById(id);
        oldPatient.setFirstName(patient.getFirstName());
        oldPatient.setLastName(patient.getLastName());
        oldPatient.setPhoneNumber(patient.getPhoneNumber());
        oldPatient.setGender(patient.getGender());
        patientRepo.save(oldPatient);
    }

    @Override
    public void removePatientById(Long id) {
        patientRepo.deleteById(id);
    }
}
