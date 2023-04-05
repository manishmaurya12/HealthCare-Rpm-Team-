package com.crossasyst.rpm.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UomResponse {
    private String code;
    private  String displayName;
    private String ucmCd;
}
