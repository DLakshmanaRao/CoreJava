package com.emp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
public class Employee {
    @JsonProperty("id")
    private int id;
    @JsonProperty("first_name")
    private String first_name;
    @JsonProperty("last_name")
    private String last_name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("salary")
    private double salary;
    @JsonProperty("currency")
    private String currency;

    public Employee(int id, String first_name, String last_name, String email, String gender, double salary, String currency) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.salary = salary;
        this.currency = currency;
    }
}
