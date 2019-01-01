package blackjack;

import util.CardUtil;

import java.util.Arrays;
import java.util.List;

public class Game {
    private String values;


    public Game(String filePath) {
        values = CardUtil.readCardListFromFile(filePath);
    }

    public void simulateGame() {
        deal(Arrays.asList(new Player("Sam"), new Player("Dealer")),
                new Deck(values));
    }

    private void deal(List<Player> players, Deck deck) {
        Hand samHand = new Hand(players.get(0));
        Hand dealerHand = new Hand(players.get(1));

        for (int i = 0; i < 2; i++) {
            samHand.takeCard(deck);
            dealerHand.takeCard(deck);
        }

        System.out.println(samHand);
        System.out.println(dealerHand);
        System.out.println(deck);
    }
}
