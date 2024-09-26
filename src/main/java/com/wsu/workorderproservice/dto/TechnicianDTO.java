package com.wsu.workorderproservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnicianDTO {

    private String technicianCode;
    private String technicianFirstName;
    private String technicianLastName;
    private String latestWorkOrderStatus;
}
