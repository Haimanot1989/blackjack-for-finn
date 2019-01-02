package blackjack;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static blackjack.Rank.ACE;
import static blackjack.Rank.FOUR;
import static blackjack.Rank.QUEEN;
import static blackjack.Rank.TEN;
import static blackjack.Suit.CLUBS;
import static blackjack.Suit.DIAMONDS;
import static blackjack.Suit.HEARTS;
import static blackjack.Suit.SPADES;

public class CardTest {

    @Test
    public void construct_card_from_suit_and_rank() {
        Card clubsAce = new Card(CLUBS, ACE);
        Card diamondsFour = new Card(DIAMONDS, FOUR);
        Card heartsTen = new Card(HEARTS, TEN);
        Card spadesQueen = new Card(SPADES, QUEEN);

        assertEquals("CA", clubsAce.uniqueCardId());
        assertEquals("D4", diamondsFour.uniqueCardId());
        assertEquals("H10", heartsTen.uniqueCardId());
        assertEquals("SQ", spadesQueen.uniqueCardId());
    }

    @Test
    public void construct_card_from_unique_card_id() {
        Card clubsAce = new Card("CA");
        Card diamondsFour = new Card("D4");
        Card heartsTen = new Card("H10");
        Card spadesQueen = new Card("SQ");

        assertEquals("CA", clubsAce.uniqueCardId());
        assertEquals("D4", diamondsFour.uniqueCardId());
        assertEquals("H10", heartsTen.uniqueCardId());
        assertEquals("SQ", spadesQueen.uniqueCardId());

    }

    @Test
    public void calculate_card_point(){
        Card clubsAce = new Card("CA");
        Card diamondsFour = new Card("D4");
        Card heartsTen = new Card("H10");
        Card spadesQueen = new Card("SQ");

        assertEquals(11, clubsAce.point());
        assertEquals(4, diamondsFour.point());
        assertEquals(10, heartsTen.point());
        assertEquals(10, spadesQueen.point());


    }
}