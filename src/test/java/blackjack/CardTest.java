package blackjack;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void construct_card_from_suit_and_rank() {
        Card clubsAce = new Card('C',"A");
        Card diamondsFour = new Card('D',"4");
        Card heartsTen = new Card('H',"10");
        Card spadesQueen = new Card('S',"Q");

        assertEquals("CA", clubsAce.uniqueCardId());
        assertEquals("D4", diamondsFour.uniqueCardId());
        assertEquals("H10", heartsTen.uniqueCardId());
        assertEquals("SQ", spadesQueen.uniqueCardId());
    }
}