package com.crossasyst.rpm.service;

import com.crossasyst.rpm.entity.UomEntity;
import com.crossasyst.rpm.mapper.UomMapper;
import com.crossasyst.rpm.model.UomRequest;
import com.crossasyst.rpm.repository.UomRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class UomService {
    @Autowired
    private final UomRepository uomRepository;
    private final UomMapper uomMapper;

    public UomService(UomRepository uomRepository, UomMapper uomMapper) {
        this.uomRepository = uomRepository;
        this.uomMapper = uomMapper;
    }

    public List<UomRequest> findAllUom() {
        List<UomEntity> uomEntities = uomRepository.findAll();
        log.info("Get All Code by Uoms");
        return uomMapper.uomEntityToModel(uomEntities);
    }

    public UomRequest getUomByCode(String code) {
        Optional<UomEntity> uomEntity = uomRepository.findById(code);
        UomRequest uomRequest = new UomRequest();
        if (uomEntity.isPresent()) {
            UomEntity uomEntity1 = uomEntity.get();
            uomRequest = uomMapper.uomEntityToModel(uomEntity1);
            log.info("uom found with code {}", code);
        } else {
            log.info("uom code not found" + code);
        }
        return uomRequest;
    }
}
