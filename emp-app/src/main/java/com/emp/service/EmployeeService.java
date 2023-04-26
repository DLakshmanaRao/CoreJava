package com.emp.service;

import com.emp.domain.Currency;
import com.emp.domain.Employee;
import com.emp.dto.EmployeeDto;
import com.emp.util.EmpUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class EmployeeService {

    private EmpUtil empUtil;
    private List<Employee> employeeList;
    private List<Currency> currencyList;

    public EmployeeService() {
        this.empUtil = new EmpUtil();
        employeeList = empUtil.readEmp();
        this.currencyList = empUtil.readJsonCurrency();
    }

    public List<EmployeeDto> getFormattedEmploees() {
        employeeList.size();
        currencyList.size();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee emp : employeeList) {
            int id = emp.getId();
            String first_name = emp.getFirst_name();
            String last_name = emp.getLast_name();
            String email = emp.getEmail();
            String gender = emp.getGender();
            double salary = emp.getSalary();
            String currency = emp.getCurrency();
            for (Currency cur : currencyList) {
                if (cur.getCode().equalsIgnoreCase(currency)) {
                    String symbol = cur.getSymbol();
                    int decimal_digits = cur.getDecimal_digits();
                    String decimal = "0".repeat(decimal_digits);
                    String sal = null;
                    try {
                        String p = "0000." + decimal;
                        DecimalFormat myFormatter = new DecimalFormat(p);
                        String output = myFormatter.format(salary);
                        sal = symbol +" "+ output;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    EmployeeDto employeeDto = EmployeeDto.builder()
                            .id(id)
                            .first_name(first_name)
                            .last_name(last_name)
                            .email(email)
                            .gender(gender)
                            .salary(sal)
                            .build();
                    employeeDtoList.add(employeeDto);
                }
            }
        }
        employeeList.size();
        return employeeDtoList;
    }


}
