package com.company;

import java.util.Random;

/**
 * Created by mikeboyd5 on 7/7/15.
 */
public class Wallet {

    private double balance = 5000;
    public double amountInWallet() {


    Random random = new Random();
    double walletAmount = random.nextInt(50000 - 40000 + 1) + 40000;
    balance = walletAmount;
    return walletAmount;


}
    public void subtractFromWallet(double betAmount){
        balance = balance - betAmount;
    }
    public void addToWallet(double moneyOnTheTable){
        balance = balance + moneyOnTheTable;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
