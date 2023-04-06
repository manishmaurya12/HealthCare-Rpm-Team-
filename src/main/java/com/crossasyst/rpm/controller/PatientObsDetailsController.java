package com.crossasyst.rpm.controller;

import com.crossasyst.rpm.service.PatientObsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientObsDetailsController {
    @Autowired
    private final PatientObsDetailsService patientObsDetailsService;


    public PatientObsDetailsController(PatientObsDetailsService patientObsDetailsService) {
        this.patientObsDetailsService = patientObsDetailsService;
    }

}
