package com.emp.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class EmployeeDto {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String salary;
}
