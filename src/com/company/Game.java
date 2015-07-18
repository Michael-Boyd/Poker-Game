package com.company;

import java.util.Scanner;

/**
 * Created by mikeboyd5 on 7/8/15.
 */
public class Game {
  Table table = new Table();


    public void startGame() {
        table.addPlayer();
//        System.out.println("Do you want to play again? yes/no");
        Scanner in = new Scanner(System.in);
        String yesNo = "yes";
        table.makeBet();
         while (yesNo.equalsIgnoreCase("yes")){

            table.dealHands();
            table.printHands();
            table.printCardCount();

            table.sortHands();
            table.compareHand();
            // you didn't print out the balance again...

            table.putHandBackInDeck();
             table.clearUpIntegerArray();
             System.out.println("Do you want to play again? yes/no");
             yesNo = in.nextLine();
        }






    }
}
