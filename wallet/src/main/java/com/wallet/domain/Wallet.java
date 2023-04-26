package com.wallet.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder

public class Wallet {
    private String mobile;
    private String name;
    private double balance;

    public Wallet(String mobile, String name, double balance) {
        this.mobile = mobile;
        this.name = name;
        this.balance = balance;
    }
}
