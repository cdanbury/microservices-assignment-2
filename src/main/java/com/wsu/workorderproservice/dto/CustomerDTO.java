package com.wsu.workorderproservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
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
// TODO: apply length validations
public class CustomerDTO {

    private Integer id;
    @NotBlank(message = "First Name must not be null or blank")
    private String firstName;
    @NotBlank(message = "Last Name must not be null or blank")
    private String lastName;
    @NotBlank(message = "Address Line1 must not be null or blank")
    private String addressLine1;
    @NotBlank(message = "Address Line2 must not be null or blank")
    private String addressLine2;
    @NotBlank(message = "City must not be null or blank")
    private String city;
    @NotBlank(message = "State must not be null or blank")
    private String state;
    @NotBlank(message = "Zip must not be null or blank")
    private String zip;
    @NotBlank(message = "Phone number must not be null or blank")
    private String phone; //TODO: apply phone validation
    @NotBlank(message = "Email must not be null or blank")
    private String email; //TODO: apply email validation
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
    private Date dateAdded;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
    private Date dateLastUpdated;
    private String latestWorkOrderStatus;
}
