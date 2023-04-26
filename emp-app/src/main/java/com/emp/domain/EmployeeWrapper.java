package com.emp.domain;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Builder
public class EmployeeWrapper {
    private List<Employee> employeesList;
    public EmployeeWrapper(List<Employee> employeesList) {
        this.employeesList = employeesList;
    }
}
