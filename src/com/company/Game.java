package com.company;

/**
 * Created by mikeboyd5 on 7/8/15.
 */
public class Game {
  Table table = new Table();


    public void startGame() {
        table.addPlayer();

        for (int i = 0; i <2 ; i++) {
            table.dealHands();
            table.printHands();
            table.printCardCount();
            table.putHandBackInDeck();
            table.sortHands();


        }






    }
}
