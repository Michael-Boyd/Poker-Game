package com.company;

import com.company.Decks.Card;

/**
 * Created by mikeboyd5 on 7/7/15.
 */
public class Player {
    private  int playerNumber;
    Wallet wallet = new Wallet();
    Hand hand = new Hand();

    public Player(Wallet wallet, Hand hand, int playerNumber) {
        this.wallet = wallet;
        this.hand = hand;
        this.playerNumber = playerNumber;
    }

    public Wallet getWallet() {

        return wallet;
    }

    public Hand getHand() {

        return hand;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }



}
