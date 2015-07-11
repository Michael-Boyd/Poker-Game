package com.company;

import com.company.Decks.Card;
import com.company.Decks.Deck;

import java.util.*;


/**
 * Created by mikeboyd5 on 7/7/15.
 */
public class Table {
   Deck deck = new Deck();
    CardHandler cardHandler = new CardHandler();
    List<Player> players = new ArrayList<Player>();


    public void addPlayer(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please input the amount of players you would like between 2 and 5");

        int numberOfPlayers = in.nextInt();
        if(numberOfPlayers < 2 || numberOfPlayers > 5){
            System.out.println("I am sorry, that was not I asked for, please try again");
           return;

        }
        for (int i = 0; i <numberOfPlayers ; i++) {
            players.add(new Player(new Wallet(), new Hand(), i+1));

        }

    }
    public void dealHands(){

        Collections.shuffle(deck.getDeck());

        for (int i = 0; i < players.size() ; i++) {

            for (int j = 0; j < 5; j++) {

                Card currentCard = deck.getDeck().get(0);

                players.get(i).hand.addCardsToHand(currentCard);

                deck.getDeck().remove(currentCard);

            }

        }
        System.out.println("Amount left in Deck: " + deck.getDeck().size());

    }


    public void printHands(){
        for (Player player: players) {
            System.out.println("Player " + player.getPlayerNumber()+" has: ");
            cardHandler.cardComparison(player.hand.getHandOfCards());

        }

    }
    public void printCardCount(){

        for (Player player: players) {
            ArrayList<Card> currentHand = player.getHand().getHandOfCards();
//            int size = currentHand.size();
//            for (int i = 0; i <size; i++) {
//                Card currentCard = currentHand.get(i);
//                player.hand.setHashMapValues(currentCard);
//            }
            player.hand.setHashMapValues(currentHand);


            }



        }

    public void putHandBackInDeck() {

        for (Player player : players) {
            ArrayList<Card> currentHand = player.getHand().getHandOfCards();
            int size = currentHand.size();
            for (int j = 0; j < size; j++) {
                Card currentCard = currentHand.get(j);
                deck.addBackToDeck(currentCard);


            }
            currentHand.clear();
        }
    }
    public void sortHands(){
        ArrayList<Hand> hands = new ArrayList<Hand>();
        for(Player player: players){
            hands.add(player.getHand());

        }
        CardComparator.findWinner(hands);
    }


}
