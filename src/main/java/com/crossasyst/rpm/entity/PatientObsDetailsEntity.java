package com.crossasyst.rpm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient_obs_detail")
public class PatientObsDetailsEntity {
    @Id
    @Column(name = "patient_obs_detail_id")
    private Long PatientObsDetailId;

    private String name;
}
