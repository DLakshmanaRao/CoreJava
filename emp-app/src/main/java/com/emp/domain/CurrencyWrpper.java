package com.emp.domain;

import lombok.*;

import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CurrencyWrpper {
    private Map<String,Currency> currency;

}
