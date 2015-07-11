package com.company;

import java.util.Random;

/**
 * Created by mikeboyd5 on 7/7/15.
 */
public class Wallet {

    public double amountInWallet() {


    Random random = new Random();
    double walletAmount = random.nextInt(50000 - 40000 + 1) + 40000;

    return walletAmount;
}
}
