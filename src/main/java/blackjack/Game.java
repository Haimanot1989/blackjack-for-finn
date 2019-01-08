package blackjack;

import util.CardUtil;

class Game {
    private final static int PLAYER_MIN_SCORE_LIMIT = 17;
    private String values;
    private Player sam = new Player("Sam");
    private Player dealer = new Player("Dealer");


    Game(String filePath) {
        values = CardUtil.readCardListFromFile(filePath);
    }

    Game(){
        values = null;
    }

    void simulateGame() {
        Deck deck = new Deck(values);
        dealInitialCardsToPlayers(deck);

        Player winner = determineWinner(deck);
        printWinner(winner.getName());
    }

    private Player determineWinner(Deck deck) {
        if (sam.hasBlackjack() || dealer.hasBlackjack()) {
            return sam;
        }
        if (sam.hasDoubleAce() && dealer.hasDoubleAce()) {
            return dealer;
        }

        sam.drawCard(deck, PLAYER_MIN_SCORE_LIMIT);
        if (sam.hasBustedHand()) {
            return dealer;
        }

        dealer.drawCard(deck, sam.score());
        if (dealer.hasBustedHand()) {
            return sam;
        }

        return dealer.score() > sam.score() ? dealer : sam;
    }

    private void dealInitialCardsToPlayers(Deck deck) {
        sam.receiveCard(deck.dealCard());
        dealer.receiveCard(deck.dealCard());
        sam.receiveCard(deck.dealCard());
        dealer.receiveCard(deck.dealCard());
    }

    private void printWinner(String winnerName) {
        System.out.println(winnerName);
        System.out.println(sam);
        System.out.println(dealer);
    }
}
