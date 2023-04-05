package com.crossasyst.rpm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PracticeRequest {
    @Size(max = 100, message = "Practice name maximum 100 character")
    private String name;
}
