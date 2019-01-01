package blackjack;

import org.apache.commons.lang3.StringUtils;
import util.CardUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static util.CardUtil.printCards;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck(String values) {
        if (StringUtils.isBlank(values)) {
            System.out.println("Test");
            cards = initializeStandard52CardDeck();
        } else {
            cards = convertValuesToCards(values);
        }
    }

    public Card dealCard() {
        return cards.remove(0);
    }

    String printCardIds() {
        return printCards(cards);
    }

    int size() {
        return cards.size();
    }

    private List<Card> initializeStandard52CardDeck() {
        List<Card> cards = new ArrayList<>();

        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                Card c = new Card(s, r);
                cards.add(c);
            }
        }

        return shuffle(cards);
    }

    private List<Card> shuffle(List<Card> cards) {
        Random random = new Random();
        IntStream.range(0, 1000).forEach((i) -> {
            int i1 = random.nextInt(52);
            int i2 = random.nextInt(52);

            Card c1 = cards.get(i1);
            Card c2 = cards.get(i2);

            cards.remove(c1);
            cards.add(i1, c2);
            cards.remove(c2);
            cards.add(i2, c1);
        });

        return cards;
    }

    private List<Card> convertValuesToCards(String values) {
        List<Card> cards = new ArrayList<>();
        String[] uniqueCardIds = values.split(",");
        for (String uniqueCardId : uniqueCardIds) {
            cards.add(new Card(uniqueCardId.trim()));
        }
        return cards;
    }

    @Override
    public String toString() {
        return CardUtil.printCards(cards);
    }

}
