package blackjack;

import org.junit.Test;

import static org.junit.Assert.*;

public class HandTest {

    @Test
    public void when_hit_card_is_added_to_hand_and_reduced_from_deck(){
        Deck deck = new Deck("CA, D5, H9, HQ, S8");
        Player sam = new Player("sam");

        Hand samsHand = new Hand(sam);
        samsHand.takeCard(deck);

        assertEquals("Hand does not contain correct cards after a hit: ", "CA", samsHand.printCardIds());
        assertEquals(1, samsHand.size());

        assertEquals("Deck does not contain correct cards after a hit: ", "D5, H9, HQ, S8", deck.printCardIds());
        assertEquals(4, deck.size());
    }

    @Test
    public void calculate_hand_score(){
        Deck deck = new Deck("CA, D5, HJ, HQ, S8");
        Player sam = new Player("sam");

        Hand samsHand = new Hand(sam);
        samsHand.takeCard(deck);
        samsHand.takeCard(deck);
        samsHand.takeCard(deck);

        assertEquals(26, samsHand.score());



    }
}