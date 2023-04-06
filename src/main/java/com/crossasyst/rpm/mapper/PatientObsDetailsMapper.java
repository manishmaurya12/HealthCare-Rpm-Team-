package com.crossasyst.rpm.mapper;

import com.crossasyst.rpm.entity.PatientObsDetailsEntity;
import com.crossasyst.rpm.model.PatientObsDetailsRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientObsDetailsMapper {
    PatientObsDetailsEntity modelToPatientObsDetailsEntity(PatientObsDetailsRequest patientObsDetailsRequest);

    List<PatientObsDetailsRequest> patientObsDetailsEntityToModel(List<PatientObsDetailsEntity> patientObsDetailsEntities);


    PatientObsDetailsRequest patientObsDetailsEntityToModel(PatientObsDetailsEntity patientObsDetailsEntity);
}
