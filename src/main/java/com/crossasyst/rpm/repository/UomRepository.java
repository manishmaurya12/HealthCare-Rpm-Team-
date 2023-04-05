package com.crossasyst.rpm.repository;

import com.crossasyst.rpm.entity.UomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UomRepository extends JpaRepository<UomEntity, String> {
}
