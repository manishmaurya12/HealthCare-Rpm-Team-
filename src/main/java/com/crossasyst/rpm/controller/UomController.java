package com.crossasyst.rpm.controller;

import com.crossasyst.rpm.model.UomRequest;
import com.crossasyst.rpm.service.UomService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "get UOM ", description = "get UOM by code")
@RequestMapping(path = "v1")
@RestController
public class UomController {
    @Autowired
    private final UomService uomService;

    public UomController(UomService uomService) {
        this.uomService = uomService;
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/uoms", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UomRequest>> getAllUom() {
        List<UomRequest> uomRequests = uomService.findAllUom();
        return new ResponseEntity<>(uomRequests, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/uoms/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UomRequest>  getUomByCode(@PathVariable String code) {
        UomRequest uomRequest = uomService.getUomByCode(code);
        return new ResponseEntity<>(uomRequest, HttpStatus.OK);
    }
}
