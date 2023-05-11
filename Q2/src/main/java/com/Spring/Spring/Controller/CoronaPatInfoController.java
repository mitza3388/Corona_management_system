package com.Spring.Spring.Controller;

import com.Spring.Spring.Entity.CoronaPatInfo;
import com.Spring.Spring.Service.CoronaPatInfoService;
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
@RequestMapping("/coronaInfo")
public class CoronaPatInfoController {
    private final CoronaPatInfoService coronaPatInfoService;

    @Autowired
    public CoronaPatInfoController(CoronaPatInfoService coronaPatInfoService) {
        this.coronaPatInfoService = coronaPatInfoService;
    }

    /*add new patient's corona info*/
    @PostMapping("/addPatInfo")
    @Transactional
    public ResponseEntity<Object> saveCoronaInfo(@Valid @RequestBody CoronaPatInfo coronaPatInfo, BindingResult bindingResult) throws SQLIntegrityConstraintViolationException {
        if (bindingResult.hasErrors()) {
            // handle validation errors
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
        }
        if(coronaPatInfo.getPositive_date().after(coronaPatInfo.getRecovery_date()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Recovery date should be before positive date");
        // save the patient to the database
        return ResponseEntity.ok(coronaPatInfoService.saveDetails(coronaPatInfo));
    }

    /* get patient corona info by id */
    @GetMapping("/get/{id}")
    public CoronaPatInfo getCoronaInfoById(@PathVariable Long id) {
        return coronaPatInfoService.getCoronaInfoById(id);
    }

    /* get all patients corona info*/
    @GetMapping("/getAll")
    public ResponseEntity<List<CoronaPatInfo>> getPatientsInfo() {
        List<CoronaPatInfo> coronaPatInfo= coronaPatInfoService.getCoronaPatDetails();
        if (coronaPatInfo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(coronaPatInfo, HttpStatus.OK);
    }
}
