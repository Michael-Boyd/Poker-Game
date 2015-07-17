package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by mikeboyd5 on 7/11/15.
 */
public class CardComparator {

    public static void findWinner(ArrayList<Hand> hands) {
        ArrayList<Integer> finalList = new ArrayList<Integer>();
        for (Hand hand : hands) {
            hand.setCardRank(calculateScore(hand));

        }


    }

    private static Integer calculateScore(Hand playerHand) {
        int size = playerHand.getUpdatedHands().size();
        int finalScore = 0;
        if (size == 5) {
            finalScore = checkStraight(playerHand);
            finalScore = checkFlush(playerHand, finalScore);

        } else if (size == 4) {
            finalScore = 2;
        } else if (size == 3) {
            finalScore = checkTwoPairOrThreeOfAKind(playerHand);
        }else if (size == 2) {
            finalScore = checkFourOfAKindOrFullHouse(playerHand);
        }
        return finalScore;
    }

    private static Integer checkFlush(Hand playerHand, int finalScore) {
        int size = playerHand.getUpdatedHands().size();
//        for (int i = 0; i <size ; i++) {
//            if(playerHand.getHandOfCards().get(i).getSuit() == )
//        }
        if ( playerHand.getHandOfCards().get(0).getSuit().equals(playerHand.getHandOfCards().get(4).getSuit()) && finalScore == 5) {
            if (playerHand.getHandOfCards().get(4).getRankValue() == 14) {
                return 10;
            }
            return 9;
        } else if (playerHand.getHandOfCards().get(0).getSuit().equals(playerHand.getHandOfCards().get(4).getSuit())) {
            return 6;
        }
        return finalScore;
    }

    private static Integer checkStraight(Hand playerHand) {
//        int size = playerHand.getUpdatedHands().size();


        if (playerHand.getUpdatedHands().get(0)[0] + 4 == playerHand.getUpdatedHands().get(4)[0]) {
            return 5;

        }
        return 0;
    }


    private static Integer checkTwoPairOrThreeOfAKind(Hand playerHand) {
        boolean threeOfOne = (playerHand.getUpdatedHands().get(0)[1] == 3);
        boolean threeOfTwo = (playerHand.getUpdatedHands().get(1)[1] == 3);
        boolean threeOfThree = (playerHand.getUpdatedHands().get(2)[1] == 3);
        if(threeOfOne || threeOfTwo || threeOfThree){
            return 4;
        }
        return 3;
    }

    private static Integer checkFourOfAKindOrFullHouse(Hand playerHand){
        boolean threeOfOne = (playerHand.getUpdatedHands().get(0)[1] == 3);
        boolean threeOfTwo = (playerHand.getUpdatedHands().get(1)[1] == 3);
        if(threeOfOne || threeOfTwo){
            return 7;
        }
        return 8;
    }


    class flushComparator implements Comparator<Hand> {

        @Override
        public int compare(Hand o1, Hand o2) {
            if (o1.getHandOfCards().get(0).getRankValue() > o2.getHandOfCards().get(0).getRankValue()) {
                return 1;
            }
            return -1;
        }

    }

}
