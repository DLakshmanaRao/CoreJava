package com.wallet.service;

import com.wallet.domain.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class WalletServiceImpl implements WalletService {

    private List<Wallet> walletList;

    public WalletServiceImpl() {
        walletList = new ArrayList<>();
    }

    @Override
    public Optional<Wallet> createWallet(String mobile, String name) {
        if (!getWallet(mobile).isEmpty()) {
            System.out.println("Wallet already existed with given mobile number: " + mobile);
            return Optional.empty();
        } else {
            Wallet wallet = Wallet.builder()
                    .mobile(mobile)
                    .name(name)
                    .balance(0.0)
                    .build();
            walletList.add(wallet);
            return Optional.of(wallet);
        }
    }

    @Override
    public Optional<Wallet> getWallet(String mobile) {
        for (Wallet w : walletList) {
            if (w.getMobile().equals(mobile)) {
                return Optional.of(w);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Wallet> walletList() {
        return walletList;
    }

    @Override
    public Optional<Wallet> addMoney(String mobile, double amount) {

        Optional<Wallet> walletlist1 = getWallet(mobile);
        if (!walletlist1.isEmpty()) {
            Wallet wallet = walletlist1.get();
            double balance = wallet.getBalance();
            wallet.setBalance(amount + balance);
            return Optional.of(wallet);
        }else {
            return Optional.empty();
        }
    }

    @Override
    public String transferMoney(String fromMobile, String toMobile, double amount){
        String retString  = "please check from mobile, tomobile and balance";
        Optional<Wallet> fromOptWallet = getWallet(fromMobile);
        Optional<Wallet> toOptWallet = getWallet(toMobile);

        if(fromOptWallet.isPresent() && toOptWallet.isPresent()){
            Wallet fromWallet = fromOptWallet.get();
            Wallet toWallet = toOptWallet.get();
            if (fromWallet.getBalance() >= amount){
                fromWallet.setBalance(fromWallet.getBalance() - amount);
                toWallet.setBalance(toWallet.getBalance() + amount);
                retString = fromMobile + " having balance of " + fromWallet.getBalance() + " and " + toMobile + " haing balance of " + toWallet.getBalance();
            }
        }
         return retString;
    }

}
