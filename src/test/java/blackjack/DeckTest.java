package blackjack;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void create_deck_from_comma_separated_string(){
        Deck deck = new Deck("CA, D4, H7, SJ");
        assertEquals("CA, D4, H7, SJ", deck.toString());
    }

    @Test
    public void creates_standard_52_card_deck_when_no_value_provided(){
        Deck deck = new Deck("");
        assertEquals(52, deck.size());
    }



}