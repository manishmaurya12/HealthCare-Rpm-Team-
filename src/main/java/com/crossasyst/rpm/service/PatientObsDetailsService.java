package com.crossasyst.rpm.service;

import com.crossasyst.rpm.mapper.PatientObsDetailsMapper;
import com.crossasyst.rpm.repository.PatientObsDetailsRepository;
import com.crossasyst.rpm.repository.PatientObsRepository;
import org.springframework.stereotype.Service;
@Service
public class PatientObsDetailsService {
    private final PatientObsDetailsRepository patientObsDetailsRepository;

    public PatientObsDetailsService(PatientObsDetailsRepository patientObsDetailsRepository, PatientObsDetailsMapper patientObsDetailsMapper, PatientObsRepository patientObsRepository) {
        this.patientObsDetailsRepository = patientObsDetailsRepository;
        this.patientObsDetailsMapper = patientObsDetailsMapper;
        this.patientObsRepository = patientObsRepository;
    }

    private final PatientObsDetailsMapper patientObsDetailsMapper;
    private final PatientObsRepository patientObsRepository;
}
