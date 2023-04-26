package com.emp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Currency {
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("name")
    private String name;
    @JsonProperty("symbol_native")
    private String symbol_native;
    @JsonProperty("decimal_digits")
    private int decimal_digits;
    @JsonProperty("rounding")
    private int rounding;
    @JsonProperty("code")
    private String code;
    @JsonProperty("name_plural")
    private String name_plural;
}
