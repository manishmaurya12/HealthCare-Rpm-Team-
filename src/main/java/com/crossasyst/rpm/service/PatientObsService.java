package com.crossasyst.rpm.service;

import com.crossasyst.rpm.entity.PatientObsEntity;
import com.crossasyst.rpm.entity.UomEntity;
import com.crossasyst.rpm.mapper.PatientObsMapper;
import com.crossasyst.rpm.model.PatientObsRequest;
import com.crossasyst.rpm.repository.PatientObsRepository;
import com.crossasyst.rpm.response.PatientObsResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class PatientObsService {
    @Autowired
    private final PatientObsRepository patientObsRepository;

    public PatientObsService(PatientObsRepository patientObsRepository, PatientObsMapper patientObsMapper) {
        this.patientObsRepository = patientObsRepository;
        this.patientObsMapper = patientObsMapper;
    }
    private final PatientObsMapper patientObsMapper;

    public PatientObsResponse createUoms(PatientObsRequest patientObsRequest) {
        PatientObsEntity patientObsEntity=patientObsMapper.modelToPatientObsEntity(patientObsRequest);
        patientObsRepository.save(patientObsEntity);
        PatientObsResponse patientObsResponse=new PatientObsResponse();
        patientObsResponse.setPatientObsId(patientObsEntity.getPatientObsId());
        UomEntity uomEntity=new UomEntity();
        uomEntity.setCode(uomEntity.getCode());
        patientObsEntity.setUomEntity(uomEntity);

        log.info("uoms id {}",patientObsEntity.getPatientObsId());
        return patientObsResponse;

    }
//    Uom uom = new Uom();
//        uom.setCode(uomCode);
//        patientObs.setUom(uom);
}
