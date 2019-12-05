package cribbage;

import java.util.ArrayList;

public class Hand {

    private static String hand;
    private static int score;

    public Hand(String hand) {
        this.hand = hand;
    }

    public static int countHandScore() {
        score = 0;
        score += fifteenTwos(score);
        return score;
    }

    private static int fifteenTwos(int currentScore) {
        return currentScore + allPossibleSums().stream()
                                               .filter(x -> x == 15)
                                               .mapToInt(x -> 2)
                                               .sum();
    }

    private static ArrayList<Integer> allPossibleSums() {
        ArrayList<Integer> allSums = new ArrayList<>();
        allSums.add(0);
        for (int rank : getRanks())
            for (int element : allSums.stream().mapToInt(x -> x).toArray())
                allSums.add(element + rank);
        return allSums;
    }


    private static int[] getRanks() {
        return getAllCards().stream()
                            .mapToInt(Card::getRank)
                            .toArray();
    }

    private static ArrayList<Card> getAllCards() {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            cards.add(new Card(hand.substring(2*i, 2*(i+1))));
        return cards;
    }
}
