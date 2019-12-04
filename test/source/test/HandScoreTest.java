package test;

import cribbage.Hand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandScoreTest {

    void checkScore(int expectedScore, String givenHand) {
        assertEquals(expectedScore, new Hand(givenHand).score());
    }

    @Test
    void fifteenTwosWithTwoCards() {
        checkScore(2, "AC6SQH2D9H");
    }

    @Test
    void fifteenTwosWithThreeCards() {
        checkScore(2, "7C2D4S9HJC");
    }

    @Test
    void fifteenTwosWithFourCards() {
        checkScore(2, "3C7D4SAH6C");
    }
}
