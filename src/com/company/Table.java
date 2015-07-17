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
    private List<Player> playersWhoHaveTheSameHighestScore = new ArrayList<Player>();
    private double moneyOnTheTable = 0;


    public void addPlayer() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input the amount of players you would like between 2 and 5");

        int numberOfPlayers = in.nextInt();
        if (numberOfPlayers < 2 || numberOfPlayers > 5) {
            System.out.println("I am sorry, that was not I asked for, please try again");
            return;

        }
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(new Wallet(), new Hand(), i + 1));

        }

    }

    public void dealHands() {

        Collections.shuffle(deck.getDeck());

        for (int i = 0; i < players.size(); i++) {

            for (int j = 0; j < 5; j++) {

                Card currentCard = deck.getDeck().get(0);

                players.get(i).hand.addCardsToHand(currentCard);

                deck.getDeck().remove(currentCard);

            }

        }
        System.out.println("Amount left in Deck: " + deck.getDeck().size());

    }


    public void printHands() {
        for (Player player : players) {
            System.out.println("Player " + player.getPlayerNumber() + " has: ");
            cardHandler.cardComparison(player.hand.getHandOfCards());
            System.out.println(" and also $" + player.getWallet().getBalance());

        }

    }

    public void printCardCount() {

        for (Player player : players) {
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

    public void sortHands() {
        ArrayList<Hand> hands = new ArrayList<Hand>();
        for (Player player : players) {
            hands.add(player.getHand());

        }
        CardComparator.findWinner(hands);
    }

    public void compareHand() {
        int score = 0;
        for (Player player : players) {
            if (player.getHand().getCardRank() > score) {
                playersWhoHaveTheSameHighestScore.clear();
                playersWhoHaveTheSameHighestScore.add(player);
                score = player.getHand().getCardRank();
            } else if (player.getHand().getCardRank() == score) {
                playersWhoHaveTheSameHighestScore.add(player);
            }
        }
        Player winner = playersWhoHaveTheSameHighestScore.get(0);

        for (int i = 1; i < playersWhoHaveTheSameHighestScore.size(); i++) {
            if (compareCardsWithinHands(winner, playersWhoHaveTheSameHighestScore.get(i))) {
                winner = playersWhoHaveTheSameHighestScore.get(i);
                //TODO if winners
            }

        }
        System.out.println("The winner is Player ");
        System.out.println(winner.getPlayerNumber());
        cardHandler.cardComparison(winner.hand.getHandOfCards());
        winner.getWallet().addToWallet(moneyOnTheTable);
        moneyOnTheTable = 0;

    }

    public boolean compareCardsWithinHands(Player winner, Player challenger) {
        for (int i = 4; i >= 0; i--) {
            if (winner.getHand().getHandOfCards().get(i).getRankValue() > challenger.getHand().getHandOfCards().get(i).getRankValue()) {
                return false;
            } else if (winner.getHand().getHandOfCards().get(i).getRankValue() < challenger.getHand().getHandOfCards().get(i).getRankValue()) {
                return true;
            }
        }
        return false;
    }

    public void makeBet (){
        System.out.println("How much money doe you want bet on each hand?");
        Scanner in = new Scanner(System.in);
        double moneyBet = in.nextDouble();
        for (Player player: players) {
            player.getWallet().subtractFromWallet(moneyBet);
            moneyOnTheTable = moneyOnTheTable + moneyBet;
        }
    }

}

