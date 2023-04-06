package com.crossasyst.rpm.service;

import com.crossasyst.rpm.entity.PatientEntity;
import com.crossasyst.rpm.mapper.PatientMapper;
import com.crossasyst.rpm.repository.PatientRepository;
import com.crossasyst.rpm.model.Patient;
import com.crossasyst.rpm.response.PatientResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }


    public PatientResponse createPatient(Patient patient) {
        log.info(patient);
        PatientEntity patientEntity = patientMapper.toEntity(patient);
        patientRepository.save(patientEntity);
        log.info("patient entity save successfully{}", patientEntity);
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setPatientId(patientEntity.getPatientId());
        return patientResponse;
    }

    public Patient getPatientById(Long patientId) {
        log.info("Finding Person By Given Id");
        Optional<PatientEntity> patientEntity = patientRepository.findByPatientIdAndDeletedFalse(patientId);
        Patient getPatient = new Patient();
        if (patientEntity.isPresent()) {
            getPatient = patientMapper.toModel(patientEntity.get());
            log.info("Patient got successfully.");
        }
        return getPatient;
    }

    public void deleteById(Long patientId) {
        patientRepository.deleteById(patientId);
        log.info("patient deleted succesfully");
    }

    public void updatePatient(Long patientId, Patient patient) {
        log.info("fetching persons");
        Optional<PatientEntity> patientEntity = patientRepository.findById(patientId);

        if (patientEntity.isPresent()) {
            PatientEntity patientEntity1 = patientMapper.toEntity(patient);
            patientEntity1.setPatientId(patientEntity.get().getPatientId());
            patientRepository.save(patientEntity1);
            log.info("Person updated successfully.");
        }
    }

}
