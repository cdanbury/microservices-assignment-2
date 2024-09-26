package com.wsu.workorderproservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "technician")
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "technician_code")
    private String technicianCode;
    @Column(name = "technician_first_name")
    private String technicianFirstName;
    @Column(name = "technician_last_name")
    private String technicianLastName;

}
