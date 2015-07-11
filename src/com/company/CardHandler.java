package com.company;

import com.company.Decks.Card;
import com.company.Decks.Deck;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mikeboyd5 on 7/8/15.
 */
public class CardHandler {

static HashMap<Integer, Integer> cardRankCounter = new HashMap<Integer, Integer>();

//    public HashMap<Integer, Integer> getCardRankCounter() {
//        return cardRankCounter;
//    }

    public static HashMap<Integer, Integer> getCardMap(){



           cardRankCounter.put(Deck.RANK.TWO.getRANK(),0);
           cardRankCounter.put(Deck.RANK.THREE.getRANK(), 0);
           cardRankCounter.put(Deck.RANK.FOUR.getRANK(), 0);
           cardRankCounter.put(Deck.RANK.FIVE.getRANK(), 0);
           cardRankCounter.put(Deck.RANK.SIX.getRANK(), 0);
           cardRankCounter.put(Deck.RANK.SEVEN.getRANK(), 0);
           cardRankCounter.put(Deck.RANK.EIGHT.getRANK(), 0);
           cardRankCounter.put(Deck.RANK.NINE.getRANK(), 0);
           cardRankCounter.put(Deck.RANK.TEN.getRANK(), 0);
           cardRankCounter.put(Deck.RANK.JACK.getRANK(), 0);
           cardRankCounter.put(Deck.RANK.QUEEN.getRANK(), 0);
           cardRankCounter.put(Deck.RANK.KING.getRANK(), 0);
           cardRankCounter.put(Deck.RANK.ACE.getRANK(), 0);

        return cardRankCounter;
       }

//    public void setCardRankCounter(HashMap<Integer, Integer> cardRankCounter) {
//        this.cardRankCounter = cardRankCounter;
//    }

    public static void getAndPrintRanks(HashMap<Integer, Integer> cardRankCounter){
    ArrayList<Integer[]> printValues = new ArrayList<>();

        for(HashMap.Entry<Integer, Integer> entry : cardRankCounter.entrySet()){
            if(entry.getValue() >0){

                printValues.add(new Integer[]{entry.getKey(),entry.getValue()});
//                System.out.println(entry.getKey() + " : " + entry.getValue());
            }



        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <printValues.size() ; i++) {

            stringBuilder.append(printValues.get(i)[0]);
            stringBuilder.append(":"+printValues.get(i)[1]);

            stringBuilder.append(" ");
        }
        System.out.println( stringBuilder.toString());



    }

    public void cardComparison(ArrayList<Card> hand) {

        printHand(hand);

    }

    private void printHand(ArrayList<Card> hand) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <hand.size() ; i++) {

            stringBuilder.append(hand.get(i).getRank());
            stringBuilder.append(" of ");
            stringBuilder.append(hand.get(i).getSuit());
            stringBuilder.append(", ");
            stringBuilder.append("\n");
        }
        System.out.println( stringBuilder.toString());

    }

//    private void printCards(ArrayList<Card> hand) {
//
//    }

}