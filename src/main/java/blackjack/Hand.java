package blackjack;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.ArrayList;
import java.util.List;

import static util.CardUtil.printCards;

public class Hand {
    private Player player;
    private List<Card> cards = new ArrayList<>();

    public Hand(Player player) {
        this.player = player;
    }

    public void takeCard(Deck deck){
        Card card = deck.dealCard();
        cards.add(card);
    }

    public String printCardIds(){
        return printCards(cards);
    }

    public int size(){
        return cards.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Hand hand = (Hand) o;

        return new EqualsBuilder()
                .append(player, hand.player)
                .append(cards, hand.cards)
                .isEquals();
    }

    @Override
    public String toString(){
        return player.getName() + ": " + printCards(cards);
    }
}
