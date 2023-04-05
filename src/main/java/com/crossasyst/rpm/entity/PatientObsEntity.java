package com.crossasyst.rpm.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient_obs")
public class PatientObsEntity {
    @Id
    @SequenceGenerator(name = "patient_obs_seq_id", sequenceName = "patient_obs_seq_id", initialValue = 2000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_obs_seq_id")
    private Long patientObsId;
    private int value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code")
    private UomEntity uomEntity;
}
