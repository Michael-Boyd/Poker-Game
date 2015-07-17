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
    private ArrayList<Integer[]> updatedHands = new ArrayList<>();
    private int cardRank;
    private int highCardOne;
    private int highCardTwp;
    private int highCardThree;
    private int highCardFour;
    private int highCardFive;
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
        setUpdatedHands(getSendToGetPrinted());
        }




    public void setUpdatedHands(HashMap<Integer,Integer> cardHashMap) {
        for (HashMap.Entry<Integer, Integer> entry : cardHashMap.entrySet()) {
            if (entry.getValue() > 0) {

                updatedHands.add(new Integer[]{entry.getKey(), entry.getValue(), 0});
            }
        }
    }


    public ArrayList<Integer[]> getUpdatedHands() {
        return updatedHands;
    }

    public ArrayList<Card> getHandOfCards() {
        return handOfCards;
    }

    public HashMap<Integer, Integer> getSendToGetPrinted() {
        return sendToGetPrinted;
    }

    public void setCardRank(int cardRank) {
        this.cardRank = cardRank;
    }

    public int getCardRank() {
        return cardRank;
    }

    public void setHighCardFive(int highCardFive) {
        this.highCardFive = highCardFive;
    }

    public void setHighCardOne(int highCardOne) {
        this.highCardOne = highCardOne;
    }

    public void setHighCardTwp(int highCardTwp) {
        this.highCardTwp = highCardTwp;
    }

    public void setHighCardThree(int highCardThree) {
        this.highCardThree = highCardThree;
    }

    public void setHighCardFour(int highCardFour) {
        this.highCardFour = highCardFour;
    }

}
