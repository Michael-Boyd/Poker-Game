package com.company;

import com.company.Decks.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by mikeboyd5 on 7/11/15.
 */
public class CardComparator  {

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
            finalScore = checkOnePair(playerHand);
        } else if (size == 3) {
            finalScore = checkTwoPairOrThreeOfAKind(playerHand);
        }else if (size == 2) {
            finalScore = checkFourOfAKindOrFullHouse(playerHand);
        }
        return finalScore;
    }

    private static Integer checkFlush(Hand playerHand, int finalScore) {
        int size = playerHand.getHandOfCards().size();
        int counter = 0;
        for (int i = 1; i <size ; i++) {
            if(playerHand.getHandOfCards().get(i - 1).getSuit().equals(playerHand.getHandOfCards().get(i).getSuit())){
                counter++;
            }
        }

        if ( counter ==5 && finalScore == 5) {
            if (playerHand.getHandOfCards().get(4).getRankValue() == 14) {
                return 10;
            }
            return 9;
        } else if (counter ==5) {
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
    private static Integer checkOnePair(Hand playerHand){
        boolean firstPair = playerHand.getUpdatedHands().get(0)[1] == 2;
        boolean secondPair = playerHand.getUpdatedHands().get(1)[1] == 2;
        boolean thirdPair = playerHand.getUpdatedHands().get(2)[1] == 2;
        boolean fourthPair = playerHand.getUpdatedHands().get(3)[1] == 2;

        if(firstPair){
            Card tempCard = playerHand.getHandOfCards().get(0);
            playerHand.getHandOfCards().set(0, playerHand.getHandOfCards().get(4));
            playerHand.getHandOfCards().set(4, tempCard);
            Card tempCard2 = playerHand.getHandOfCards().get(1);
            playerHand.getHandOfCards().set(1, playerHand.getHandOfCards().get(3));
            playerHand.getHandOfCards().set(3, tempCard2);
            Card tempCard3 = playerHand.getHandOfCards().get(0);
            playerHand.getHandOfCards().set(0, playerHand.getHandOfCards().get(2));
            playerHand.getHandOfCards().set(2, tempCard3);
        }
        if(secondPair){
            Card tempCard = playerHand.getHandOfCards().get(1);
            playerHand.getHandOfCards().set(1, playerHand.getHandOfCards().get(3));
            playerHand.getHandOfCards().set(3, tempCard);
            Card tempCard2 = playerHand.getHandOfCards().get(2);
            playerHand.getHandOfCards().set(2, playerHand.getHandOfCards().get(4));
            playerHand.getHandOfCards().set(4, tempCard2);
        }
        if(thirdPair){
            Card tempCard = playerHand.getHandOfCards().get(2);
            playerHand.getHandOfCards().set(2, playerHand.getHandOfCards().get(4));
            playerHand.getHandOfCards().set(4, tempCard);
        }

        Collections.sort(playerHand.getUpdatedHands(), new CardArrayComparator());
        return 2;
    }

    private static Integer checkTwoPairOrThreeOfAKind(Hand playerHand) {
        boolean threeOfOne = (playerHand.getUpdatedHands().get(0)[1] == 3);
        if(threeOfOne){
            Card tempCard = playerHand.getHandOfCards().get(1);
            playerHand.getHandOfCards().set(1, playerHand.getHandOfCards().get(4));
            playerHand.getHandOfCards().set(4, tempCard);
            Card tempCard2 = playerHand.getHandOfCards().get(1);
            playerHand.getHandOfCards().set(0, playerHand.getHandOfCards().get(3));
            playerHand.getHandOfCards().set(3, tempCard2);

        }
        boolean threeOfTwo = (playerHand.getUpdatedHands().get(1)[1] == 3);
        if(threeOfTwo){
            Card tempCard = playerHand.getHandOfCards().get(1);
            playerHand.getHandOfCards().set(1, playerHand.getHandOfCards().get(4));
            playerHand.getHandOfCards().set(4,tempCard);

        }
        boolean threeOfThree = (playerHand.getUpdatedHands().get(2)[1] == 3);
        if(threeOfOne || threeOfTwo || threeOfThree){
            return 4;
        }
        boolean firstTwo = (playerHand.getUpdatedHands().get(0)[1]==2);
        boolean secondTwo= (playerHand.getUpdatedHands().get(1)[1]==2);
        boolean threeTwo = (playerHand.getUpdatedHands().get(2)[1]==2);
        if(firstTwo  && secondTwo){
            Card tempCard = playerHand.getHandOfCards().get(0);
            playerHand.getHandOfCards().set(0, playerHand.getHandOfCards().get(4));
            playerHand.getHandOfCards().set(4,tempCard);
            Card tempCard2 = playerHand.getHandOfCards().get(4);
            playerHand.getHandOfCards().set(2, playerHand.getHandOfCards().get(4));
            playerHand.getHandOfCards().set(4,tempCard2);
        }
        if(firstTwo && threeOfOne){
            Card tempCard = playerHand.getHandOfCards().get(0);
            playerHand.getHandOfCards().set(0, playerHand.getHandOfCards().get(2));
            playerHand.getHandOfCards().set(2,tempCard);
        }
        return 3;
    }

    private static Integer checkFourOfAKindOrFullHouse(Hand playerHand){
        boolean threeOfOne = (playerHand.getUpdatedHands().get(0)[1] == 3);
        boolean threeOfTwo = (playerHand.getUpdatedHands().get(1)[1] == 3);
        if(threeOfOne){
            Card tempCard = playerHand.getHandOfCards().get(0);
            playerHand.getHandOfCards().set(0, playerHand.getHandOfCards().get(4));
            playerHand.getHandOfCards().set(4,tempCard);
            Card tempCard2 = playerHand.getHandOfCards().get(2);
            playerHand.getHandOfCards().set(2, playerHand.getHandOfCards().get(3));
            playerHand.getHandOfCards().set(3,tempCard2);
        }

        if(threeOfOne || threeOfTwo){
            return 7;
        }

        boolean firstOfFour = playerHand.getUpdatedHands().get(0)[1] == 4;
        if(firstOfFour){
            Card tempCard = playerHand.getHandOfCards().get(0);
            playerHand.getHandOfCards().set(0, playerHand.getHandOfCards().get(4));
            playerHand.getHandOfCards().set(4,tempCard);
        }
        return 8;
    }


    public static class SortCards implements Comparator<Card>{


        @Override
        public int compare(Card o1, Card o2) {
            if(o1.getRankValue() > o2.getRankValue()){
                return 1;
            }
            return -1;
        }

    }

    public static class CardArrayComparator implements Comparator<Integer[]>{


        @Override
        public int compare(Integer[] o1, Integer[] o2) {
           if(o1[1] > o2[1]){
               return 1;
           }else if(o1[1] == o2[1]){
               if(o1[0] > o2[0]){
                   return 1;
               }
           }
            return -1;
        }
    }

}
