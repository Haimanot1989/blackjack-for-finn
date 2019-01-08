package blackjack;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.ArrayList;
import java.util.List;

import static util.CardUtil.printCards;

public class Hand {
    private List<Card> cards = new ArrayList<>();

    void addCard(Card card) {
        cards.add(card);
    }

    String printCardIds() {
        return printCards(cards);
    }

    int size() {
        return cards.size();
    }

    int score() {
        return cards.stream().map(Card::point).reduce(0, (c1, c2) -> (c1 + c2));
    }

    public boolean isInitiallyBlackjack() {
        return size() == 2 && score() == 21;
    }

    boolean isInitiallyDoubleAce() {
        return cards.size() == 2 && cards.stream().allMatch(Card::isAce);
    }

    boolean busted() {
        return score() > 21;
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
                .append(cards, hand.cards)
                .isEquals();
    }

    @Override
    public String toString() {
        return printCards(cards);
    }
}
