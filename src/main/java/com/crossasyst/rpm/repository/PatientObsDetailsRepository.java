package com.crossasyst.rpm.repository;

import com.crossasyst.rpm.entity.PatientObsDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientObsDetailsRepository extends JpaRepository<PatientObsDetailsEntity,Long> {
}
