package blackjack;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static util.CardUtil.printCards;

public class Deck {
    private List<Card> cards;

    public Deck(String values) {
        if (StringUtils.isBlank(values)) {
            cards = initializeStandard52CardDeck();
        } else {
            cards = convertValuesToCards(values);
        }
    }

    Card dealCard() {
        return cards.remove(0);
    }

    boolean isEmpty() {
        return cards.isEmpty();
    }

    int size(){
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

    private List<Card> convertValuesToCards(String commaSeperatedUniqueCardIds) {
        String[] uniqueCardIds = commaSeperatedUniqueCardIds.split(",");
        return Arrays.stream(uniqueCardIds)
                .map(id -> new Card(id.trim()))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return printCards(cards);
    }

}
