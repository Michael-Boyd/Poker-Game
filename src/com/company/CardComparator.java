package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mikeboyd5 on 7/11/15.
 */
public class CardComparator {

    public static String findWinner(ArrayList<Hand> hands){
     ArrayList<Integer> finalList = new ArrayList<Integer>();
        for(Hand hand: hands){
            finalList.add(calculateScore(hand));
        }

        return "";
    }
    private static Integer calculateScore(Hand playerHand){

       return 0;
    }
}
