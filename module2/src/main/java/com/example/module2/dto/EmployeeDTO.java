package com.example.module2.dto;

import com.example.module2.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    @NotNull(message = "Required field in Employee: name")
    @NotBlank
    private String name;
    @Email
    private String email;
    @Max(value = 80)
    @Min(value = 18)
    private Integer age;
    private LocalDate dateOfJoining;
    @NotBlank(message = "Role of employee cannot be blank")
    @EmployeeRoleValidation
    private String role;
    @JsonProperty("isActive")
    private Boolean isActive;
    @NotNull() @Positive()
    private Double salary;

}
