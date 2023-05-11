package com.Spring.Spring.Service;

import com.Spring.Spring.Entity.Patient;
import com.Spring.Spring.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepo patientRepo;

    @Autowired
    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public Patient saveDetails(Patient patient) throws SQLIntegrityConstraintViolationException {
        if (patientRepo.existsById(patient.getId()))
            throw new SQLIntegrityConstraintViolationException();
        return patientRepo.save(patient);
    }

    public List<Patient> getPatients() {
        return patientRepo.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepo.findById(id).get();
    }

    public List<Object[]> getAllDet(long id) {
        return patientRepo.getPatientDetails(id);
    }


}
