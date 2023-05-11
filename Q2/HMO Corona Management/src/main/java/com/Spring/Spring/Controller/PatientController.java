package com.Spring.Spring.Controller;

import com.Spring.Spring.Entity.Patient;
import com.Spring.Spring.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    /* insert new patient */
    @PostMapping("/addPatient")
    @Transactional
    public ResponseEntity<Object> savePatientData(@Valid @RequestBody Patient patient, BindingResult bindingResult) throws SQLIntegrityConstraintViolationException {
        if (bindingResult.hasErrors()) {
            // handle validation errors
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
        }
        // save the patient to the database
        return ResponseEntity.ok(patientService.saveDetails(patient));
    }

    /* get all existing patients */
    @GetMapping("/getAll")
    public ResponseEntity<List<Patient>> getPatients() {
        List<Patient> patients = patientService.getPatients();
        if (patients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    /* get patient by id */
    @GetMapping("/get/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    /* get personal and corona details */
    @GetMapping("/getAllDet/{id}")
    public List<Object[]> getAll(@PathVariable Long id) {
        return patientService.getAllDet(id);
    }
}
