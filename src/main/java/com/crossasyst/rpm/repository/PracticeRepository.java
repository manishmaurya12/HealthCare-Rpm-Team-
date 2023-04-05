package com.crossasyst.rpm.repository;

import com.crossasyst.rpm.entity.PracticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PracticeRepository extends JpaRepository<PracticeEntity, Long> {
    List<PracticeEntity> findByActiveTrue();

    @Override
    @Modifying
    @Query("UPDATE PracticeEntity SET active = false WHERE practiceId = ?1")
    void deleteById(Long practiceId);

    @Query(value = "SELECT * FROM practice p WHERE p.enterprise_id = ?1 AND p.active = '0' ", nativeQuery = true)
    List<PracticeEntity> findByEnterpriseId(Long enterpriseId);

    @Query(value = "SELECT * FROM practice p WHERE p.practice_id = ?1 AND p.active = '0' ", nativeQuery = true)
    Optional<PracticeEntity> findById(Long practiceId);
}
