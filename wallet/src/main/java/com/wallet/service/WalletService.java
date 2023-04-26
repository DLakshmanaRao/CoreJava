package com.wallet.service;

import com.wallet.domain.Wallet;

import java.util.List;
import java.util.Optional;

public interface WalletService {

    Optional<Wallet> createWallet(String mobile, String name);

    Optional<Wallet> getWallet(String mobile);

    List<Wallet> walletList();

    Optional<Wallet> addMoney(String mobile, double amount);

    String transferMoney(String fromMobile, String toMobile, double amount);

}
