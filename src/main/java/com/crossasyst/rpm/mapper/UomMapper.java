package com.crossasyst.rpm.mapper;

import com.crossasyst.rpm.entity.EnterpriseEntity;
import com.crossasyst.rpm.entity.UomEntity;
import com.crossasyst.rpm.model.Enterprise;
import com.crossasyst.rpm.model.UomRequest;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface UomMapper {
    UomEntity modelToUomEntity(UomRequest uomRequest);

    List<UomRequest> uomEntityToModel(List<UomEntity> uomEntities);
    UomRequest uomEntityToModel(UomEntity uomEntity);
}
