package com.crossasyst.rpm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "uom")
public class UomEntity {
    @Id
    @Column(name = "code")
    private String code;
    @Column(name = "display_name")
    private  String displayName;
    @Column(name = "ucmcd")
    private String ucmCd;

}
