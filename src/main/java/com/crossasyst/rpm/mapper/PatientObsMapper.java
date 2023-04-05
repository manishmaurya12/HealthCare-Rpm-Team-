package com.crossasyst.rpm.mapper;

import com.crossasyst.rpm.entity.EnterpriseEntity;
import com.crossasyst.rpm.entity.PatientObsEntity;
import com.crossasyst.rpm.model.Enterprise;
import com.crossasyst.rpm.model.PatientObsRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientObsMapper {

    PatientObsEntity modelToPatientObsEntity(PatientObsRequest patientObsRequest);

    List<PatientObsRequest> PatientObsEntityToModel(List<PatientObsEntity> patientObsEntities);

    PatientObsRequest PatientObsEntityToModel(PatientObsEntity patientObsEntity);

}
