package blackjack;

import org.junit.Test;

import static org.junit.Assert.*;

public class HandTest {

    @Test
    public void when_hit_card_is_added_to_hand_and_reduced_from_deck(){
        Hand samsHand = new Hand();
        samsHand.addCard(new Card("CA"));

        assertEquals("Hand does not contain correct cards after a hit: ", "CA", samsHand.printCardIds());
        assertEquals(1, samsHand.size());
    }

    @Test
    public void calculate_hand_score(){
        Hand playerHand = new Hand();
        playerHand.addCard(new Card("CA"));
        playerHand.addCard(new Card("D5"));
        playerHand.addCard(new Card("HJ"));

        assertEquals(26, playerHand.score());
    }
}