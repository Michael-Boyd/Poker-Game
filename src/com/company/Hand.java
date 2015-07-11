package com.company;

import com.company.Decks.Card;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mikeboyd5 on 7/7/15.
 */
public class Hand {

    private HashMap<Integer, Integer> sendToGetPrinted;
    private ArrayList<Card> handOfCards = new ArrayList<Card>();
    public void addCardsToHand(Card card){
    handOfCards.add(card);

    }
    public void setHashMapValues(ArrayList<Card> currentHand){

        int size = currentHand.size();
        sendToGetPrinted = CardHandler.getCardMap();
        int tempValue =0;
        for (int i = 0; i <size ; i++) {
            Card card = currentHand.get(i);
            tempValue =  CardHandler.cardRankCounter.get(card.getRankValue());
            tempValue++;
            CardHandler.cardRankCounter.put(card.getRankValue(),tempValue);

        }
        CardHandler.getAndPrintRanks(sendToGetPrinted);
        }





    public ArrayList<Card> getHandOfCards() {
        return handOfCards;
    }

    public HashMap<Integer, Integer> getSendToGetPrinted() {
        return sendToGetPrinted;
    }
}
