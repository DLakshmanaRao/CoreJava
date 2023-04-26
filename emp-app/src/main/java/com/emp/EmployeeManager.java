package com.emp;

import com.emp.domain.Currency;
import com.emp.dto.EmployeeDto;
import com.emp.service.EmployeeService;
import com.emp.util.EmpUtil;

import java.util.List;

public class EmployeeManager {
    public static void main(String[] args) {
        EmpUtil empUtil = new EmpUtil();
//        System.out.println(empUtil.readEmp());

//        List<Currency> list = empUtil.readJsonCurrency();
//        list.forEach(ele -> {
//            System.out.println(ele);
//        });

        EmployeeService employeeService = new EmployeeService();

        List<EmployeeDto> list = employeeService.getFormattedEmploees();
        int i = 1;
        for (EmployeeDto emp : list) {
            System.out.println(emp.getSalary());
            i++;
        }

    }
}
