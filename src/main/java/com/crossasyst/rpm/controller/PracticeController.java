package com.crossasyst.rpm.controller;

import com.crossasyst.rpm.model.PracticeRequest;
import com.crossasyst.rpm.response.PracticeResponse;
import com.crossasyst.rpm.service.PracticeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Create practice", description = "Create practice")
@RestController
@RequestMapping(path = "v1")
public class PracticeController {
    @Autowired
    private final PracticeService practiceService;

    public PracticeController(PracticeService practiceService) {
        this.practiceService = practiceService;
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/enterprise/{enterpriseId}/practices", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PracticeResponse> createPractice(@PathVariable Long enterpriseId, @RequestBody @Valid PracticeRequest practiceRequest) {
        PracticeResponse practiceResponse = practiceService.createPractice(enterpriseId, practiceRequest);
        return new ResponseEntity<>(practiceResponse, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/enterprise/{enterpriseId}/practices", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PracticeRequest>> getAllPractice(@PathVariable Long enterpriseId) {
        List<PracticeRequest> practiceRequests = practiceService.getAllPractice(enterpriseId);
        return new ResponseEntity<>(practiceRequests, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/practices/{practiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PracticeRequest> getPractice(@PathVariable Long practiceId) {
        PracticeRequest practiceRequest = practiceService.getPractice(practiceId);
        return new ResponseEntity<>(practiceRequest, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PutMapping(path = "/enterprise/{enterpriseId}/practices/{practiceId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePractice(@PathVariable Long practiceId,Long enterpriseId, @RequestBody PracticeRequest practiceRequest) {
        practiceService.updatePractice(practiceId,enterpriseId ,practiceRequest);
        return new ResponseEntity<>("Practice updated successfully", HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @DeleteMapping(value = "/practices/{practiceId}")
    public ResponseEntity<String> deletePracticeById(@PathVariable Long practiceId) {
        practiceService.deletePracticeById(practiceId);
        return new ResponseEntity<>("Practice delete Successfully", HttpStatus.OK);
    }
}
