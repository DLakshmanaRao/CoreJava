package com.emp.util;

import com.emp.domain.Currency;
import com.emp.domain.Employee;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmpUtil {

    public List<Employee> readEmp() {
        List<Employee> empList = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Employee> em = objectMapper.readValue(this.getClass().getResourceAsStream("/emp-data.json"), new TypeReference<List<Employee>>() {
            });
            for (Employee emp : em) {
                Employee emp1 = Employee.builder()
                        .id(emp.getId())
                        .first_name(emp.getFirst_name())
                        .last_name(emp.getLast_name())
                        .email(emp.getEmail())
                        .gender(emp.getGender())
                        .salary(emp.getSalary())
                        .currency(emp.getCurrency())
                        .build();
                empList.add(emp1);
            }
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return empList;
    }


    public List<Currency> readJsonCurrency() {
        List<Currency> currencyList = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Currency> cw = objectMapper.readValue(this.getClass().getResourceAsStream("/common-currency.json"), new TypeReference<Map<String, Currency>>() {
            });
            cw.forEach((Name, currency) -> {
                Currency cur = new Currency();
                cur.setName(Name);
                cur = Currency.builder()
                        .symbol(currency.getSymbol())
                        .name(currency.getName())
                        .symbol_native(currency.getSymbol_native())
                        .decimal_digits(currency.getDecimal_digits())
                        .rounding(currency.getRounding())
                        .code(currency.getCode())
                        .name_plural(currency.getName_plural())
                        .build();
                currencyList.add(cur);
            });
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return currencyList;
    }
}
