package com.crossasyst.rpm.controller;


import com.crossasyst.rpm.model.Patient;
import com.crossasyst.rpm.response.PatientResponse;
import com.crossasyst.rpm.service.PatientService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class PatientController {
    @Autowired
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping(value="/patients",produces =MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponse> createPatient(@RequestBody Patient patient){
        PatientResponse patientResponse = patientService.createPatient(patient);
        return new ResponseEntity<>(patientResponse, HttpStatus.CREATED);
    }
    @GetMapping(value ="/patients/{patientId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Patient> getPatientById(@PathVariable Long patientId){
        Patient patient = patientService.getPatientById(patientId);
        return new ResponseEntity<>(patient,HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PutMapping(path = "/patients/{patientId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePerson(@PathVariable Long patientId, @RequestBody Patient patient) {
        patientService.updatePatient(patientId, patient);
        return new ResponseEntity<>("Person updated successfully", HttpStatus.OK);
    }


    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @DeleteMapping(path = "/patients/{patientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteById(@PathVariable Long patientId) {
        patientService.deleteById(patientId);
        return new ResponseEntity<>("remove patient successfully", HttpStatus.OK);
    }
}