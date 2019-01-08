package blackjack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerTest {
    @Test
    public void player_has_blackjack(){
        Deck deck = new Deck("CA, HJ, HQ, S8, D5");
        Player sam = new Player("sam");
        Player dealer = new Player("Dealer");

        sam.receiveCard(deck.dealCard());
        dealer.receiveCard(deck.dealCard());
        sam.receiveCard(deck.dealCard());
        dealer.receiveCard(deck.dealCard());


        assertTrue(sam.hasBlackjack());
    }

    @Test
    public void is_not_blackjack(){
        Deck deck = new Deck("CA, D5, H2, HQ, S8");
        Player sam = new Player("sam");
        Player dealer = new Player("Dealer");

        sam.receiveCard(deck.dealCard());
        dealer.receiveCard(deck.dealCard());
        sam.receiveCard(deck.dealCard());
        dealer.receiveCard(deck.dealCard());


        assertFalse(sam.hasBlackjack());
    }

    @Test
    public void player_stops_drawing_cards_when_score_over_17(){
        Deck deck = new Deck("CA, D5, S2, H4, HJ, HQ, S8");
        Player sam = new Player("sam");

        sam.drawCard(deck, 17);

        assertEquals(18, sam.score());
    }
}