package com.crossasyst.rpm.repository;

import com.crossasyst.rpm.entity.PatientObsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientObsRepository extends JpaRepository<PatientObsEntity,Long> {
}
