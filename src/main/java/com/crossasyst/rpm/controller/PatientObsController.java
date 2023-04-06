package com.crossasyst.rpm.controller;

import com.crossasyst.rpm.model.PatientObsRequest;
import com.crossasyst.rpm.response.PatientObsResponse;
import com.crossasyst.rpm.service.PatientObsService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Create PatientObs", description = "Create PatientObs")
@RequestMapping(path = "v1")
@RestController
public class PatientObsController {
    @Autowired
    private final PatientObsService patientObsService;

    public PatientObsController(PatientObsService patientObsService) {
        this.patientObsService = patientObsService;
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/patientobs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientObsResponse> createUoms(@RequestBody @Valid PatientObsRequest patientObsRequest) {
        PatientObsResponse patientObsResponse = patientObsService.createUoms(patientObsRequest);
        return new ResponseEntity<>(patientObsResponse, HttpStatus.OK);
    }
}
