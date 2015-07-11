package com.company.Decks;

import com.company.Decks.Card;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by mikeboyd5 on 7/7/15.
 */
public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();
    public enum SUIT {
        CLUBS("Clubs"), DIAMONDS("Diamonds"), HEARTS("Hearts"), SPADES("Spades");
        private final String DISPLAYSUIT;
        SUIT(String displaySuit ) {

            this.DISPLAYSUIT = displaySuit;
        }
    }
    public enum RANK {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

        private final int RANK;

         RANK( int i ) {
            this.RANK = i;

        }


        public int getRANK() {
            return RANK;
        }
    }
    public Deck (){
        for (SUIT suit: SUIT.values()) {

            for (RANK rank : RANK.values()){
                deck.add(new Card(suit.name(), rank.name(), rank.getRANK()));
            }
        }

    }



    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void addBackToDeck(Card card){
        if(!deck.contains(card)){
            deck.add(card);
        }

    }
}
