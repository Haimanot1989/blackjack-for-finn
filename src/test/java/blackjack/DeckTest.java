package blackjack;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void create_deck_from_comma_separated_string(){
        Deck deck = new Deck("CA, D4, H7, SJ");
        System.out.println(deck);
        assertEquals("CA, D4, H7, SJ", deck.printCardIds());
    }

}