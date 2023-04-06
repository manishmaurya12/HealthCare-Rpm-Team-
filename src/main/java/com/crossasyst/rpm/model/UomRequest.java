package com.crossasyst.rpm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UomRequest {
    @Size(max = 30)
    private String code;
    @Size(max = 100)
    private String ucmCd;
    @Size(max = 30)
    private  String displayName;
}
