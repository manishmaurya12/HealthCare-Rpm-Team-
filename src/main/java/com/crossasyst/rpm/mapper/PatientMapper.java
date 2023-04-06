package com.crossasyst.rpm.mapper;


import com.crossasyst.rpm.entity.PatientEntity;
import com.crossasyst.rpm.model.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientEntity toEntity(Patient patient);

    List<Patient> entityToModel(List<PatientEntity> patientEntities);

    Patient toModel(PatientEntity patientEntity);
}