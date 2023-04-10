package com.crossasyst.rpm.service;

import com.crossasyst.rpm.entity.EnterpriseEntity;
import com.crossasyst.rpm.entity.PracticeEntity;
import com.crossasyst.rpm.exception.GlobalException;
import com.crossasyst.rpm.mapper.PracticeMapper;
import com.crossasyst.rpm.model.PracticeRequest;
import com.crossasyst.rpm.repository.EnterpriseRepository;
import com.crossasyst.rpm.repository.PracticeRepository;
import com.crossasyst.rpm.response.PracticeResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class PracticeService {
    @Autowired
    private final PracticeRepository practiceRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final PracticeMapper practiceMapper;

    public PracticeService(PracticeRepository practiceRepository, EnterpriseRepository enterpriseRepository, PracticeMapper practiceMapper) {
        this.practiceRepository = practiceRepository;
        this.enterpriseRepository = enterpriseRepository;
        this.practiceMapper = practiceMapper;
    }

    public PracticeResponse createPractice(Long enterpriseId, PracticeRequest practiceRequest) {

        Optional<EnterpriseEntity> enterpriseEntity = enterpriseRepository.findById(enterpriseId);
        PracticeEntity practiceEntity = new PracticeEntity();
        if (enterpriseEntity.isPresent()) {
            practiceEntity = practiceMapper.modelToPracticeEntity(practiceRequest);
            practiceEntity.setEnterpriseEntity(enterpriseEntity.get());
            practiceRepository.save(practiceEntity);
        } else {

            log.info("Enterprise not found with id " + enterpriseId);
        }
        PracticeResponse practiceResponse = new PracticeResponse();
        if (practiceEntity.getPracticeId() != null) {

            practiceResponse.setPracticeId(practiceEntity.getPracticeId());
        }
        return practiceResponse;

    }

    public List<PracticeRequest> getAllPractice(Long enterpriseId) {

        Optional<EnterpriseEntity> enterpriseEntity = Optional.ofNullable(enterpriseRepository.findById(enterpriseId).orElseThrow(GlobalException::new));

        List<PracticeEntity> practiceEntityList;
        List<PracticeRequest> practiceRequestList = new ArrayList<>();

        if (enterpriseEntity.isPresent()) {
            practiceEntityList = practiceRepository.findByEnterpriseId(enterpriseId);

            practiceRequestList = practiceMapper.practiceEntityToModel(practiceEntityList);
        }
        return practiceRequestList;
    }

    public PracticeRequest getPractice(Long practiceId) {
        log.info("Fetching practices");
        Optional<PracticeEntity> practiceEntity = Optional.ofNullable(practiceRepository.findById(practiceId).orElseThrow(GlobalException::new));
//        Optional<EnterpriseEntity> enterpriseEntity = Optional.ofNullable(enterpriseRepository.findByIdAndActiveTrue(enterpriseId).orElseThrow(GlobalException::new));

        PracticeRequest practiceRequest = new PracticeRequest();
        if (practiceEntity.isPresent()) {
            practiceRequest = practiceMapper.practiceEntityToModel(practiceEntity.get());
            log.info("Practice got successfully");
        } else {
            log.info("practiceId not found" + practiceId);
        }
        return practiceRequest;
    }

    public void updatePractice(Long practiceId, Long enterpriseId, PracticeRequest practiceRequest) {
        log.info("Fetching Practice");
        Optional<EnterpriseEntity> enterpriseEntity = enterpriseRepository.findById(enterpriseId);
        Optional<PracticeEntity> practiceEntity = practiceRepository.findById(practiceId);
        if (practiceEntity.isPresent() && enterpriseEntity.isPresent()) {
            PracticeEntity practiceEntity1 = practiceMapper.modelToPracticeEntity(practiceRequest);
            practiceEntity1.setPracticeId(practiceEntity.get().getPracticeId());
            practiceEntity1.setEnterpriseEntity(enterpriseEntity.get());
            practiceRepository.save(practiceEntity1);
            log.info("Practice updated successfully");
        }
    }

    public void deletePracticeById(Long practiceId) {
        practiceRepository.deleteById(practiceId);
        log.info("practice Id {}", practiceId + "deleted successfully");
    }
}
