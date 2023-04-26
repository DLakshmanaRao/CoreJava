package com.wallet;

import com.wallet.domain.Wallet;
import com.wallet.service.WalletService;
import com.wallet.service.WalletServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class WalletManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WalletService walletService = new WalletServiceImpl();
        System.out.println("select option : 1) Create Wallet, 2) Get Wallet, 3)Wallet List, 4) Add Amount, 5)Transfer Amount");
        System.out.println("-".repeat(150));
        while (true) {
            System.out.printf("Select your option : ");
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    sc.nextLine();
                    System.out.println("enter mobile number");
                    String mobileno = sc.nextLine();
                    System.out.println("enter name");
                    String name = sc.nextLine();
                    Optional<Wallet> wallet = walletService.createWallet(mobileno, name);
                    if (!wallet.isEmpty()) {
                        Wallet wal = wallet.get();
                        System.out.println(wal);
                    } else {
                        System.out.println("wallet not existed");
                    }
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("enter mobile number");
                    String mobile = sc.nextLine();
                    Optional<Wallet> wall = walletService.getWallet(mobile);
                    if (!wall.isEmpty()) {
                        Wallet wal = wall.get();
                        System.out.println(wal);
                        System.out.println(wal.getMobile() + "--" + wal.getName() + "--" + wal.getBalance());
                    }
                    break;
                case 3:
                    List<Wallet> walletlist = walletService.walletList();
                    walletlist.forEach(wallet1 -> {
                        System.out.println(wallet1 + "\n");
                    });
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("enter mobile number");
                    String mobile1 = sc.nextLine();
                    System.out.println("enter amount to be added to wallet ");
                    double amount = sc.nextDouble();
                    Optional<Wallet> bal = walletService.addMoney(mobile1, amount);
                    if (!bal.isEmpty()) {
                        Wallet wal = bal.get();
                        System.out.println(wal.getMobile() + "--" + wal.getName() + "--" + wal.getBalance());
                    }
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("enter source mobile number");
                    String fromMobile = sc.nextLine();
                    System.out.println("enter to mobile number");
                    String toMobile = sc.nextLine();
                    System.out.println("enter amount tobe transfer ");
                    double amount1 = sc.nextDouble();
                    String balance = walletService.transferMoney(fromMobile, toMobile, amount1);
                    System.out.println(balance);
                    break;
            }
        }


    }
}
