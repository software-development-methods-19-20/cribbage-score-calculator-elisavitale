package cribbage;

import java.util.HashMap;

public class Card {

    private int rank;
    private String suite;

    public Card(String card) {
        this.rank = setRank(card.substring(0, 1));
        this.suite = card.substring(1);
    }

    public int getRank() {
        return rank;
    }

    public String getSuite() {
        return suite;
    }

    public int setRank(String rank) {
        HashMap<String, Integer> rankValues = new HashMap<>();
        rankValues.put("A", 1);
        rankValues.put("J", 10);
        rankValues.put("Q", 10);
        rankValues.put("K", 10);
        for (int i = 2; i <= 10; i++)
            rankValues.put("" + i, i);
        return rankValues.get(rank);
    }
}
