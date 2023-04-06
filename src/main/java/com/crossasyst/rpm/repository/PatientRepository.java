package com.crossasyst.rpm.repository;

import com.crossasyst.rpm.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    Optional<PatientEntity> findByPatientIdAndDeletedFalse(Long patientId);

    @Override

    @Query("UPDATE PatientEntity a SET a.deleted = true WHERE a.patientId = ?1")
    @Modifying
    void deleteById(Long patientId);

}
