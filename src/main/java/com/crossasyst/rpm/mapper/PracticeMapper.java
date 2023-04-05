package com.crossasyst.rpm.mapper;

import com.crossasyst.rpm.entity.PracticeEntity;
import com.crossasyst.rpm.model.PracticeRequest;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface PracticeMapper {
    PracticeEntity modelToPracticeEntity(PracticeRequest practiceRequest);
    List<PracticeRequest> practiceEntityToModel(List<PracticeEntity> practiceEntities);
    PracticeRequest practiceEntityToModel(PracticeEntity practiceEntity);
}
