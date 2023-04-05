package com.crossasyst.rpm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UomRequest {
    private String code;
    private String ucmCd;
    private  String displayName;
}
