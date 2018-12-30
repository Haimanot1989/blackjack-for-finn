package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    Deck(String values){
        String[] uniqueCardIds = values.split(",");

        for (String uniqueCardId: uniqueCardIds) {
            cards.add(new Card(uniqueCardId.trim()));
        }
    }

    String printCardIds(){
        return cards.stream()
                .map(c -> c.uniqueCardId() + ", ")
                .reduce("", String::concat)
                .replaceAll(", $", "");
    }

}
