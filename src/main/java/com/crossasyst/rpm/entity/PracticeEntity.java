package com.crossasyst.rpm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "practice")
public class PracticeEntity {
    @Id
    @SequenceGenerator(name = "practice_seq_id", sequenceName = "practice_seq_id", initialValue = 10001, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "practice_seq_id")
    @Column(name = "practice_id")
    private Long practiceId;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private boolean active=Boolean.TRUE;

    @OneToOne
    @JoinColumn(name = "enterprise_id")
    private EnterpriseEntity enterpriseEntity;
}
