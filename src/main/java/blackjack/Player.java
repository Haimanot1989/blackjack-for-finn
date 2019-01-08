package blackjack;

public class Player {
    private String name;
    private Hand hand;

    Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    String getName(){
        return name;
    }

    void drawCard(Deck deck, int limitScore){
        while (hand.score() <= limitScore && !deck.isEmpty()){
            hand.addCard(deck.dealCard());
        }
    }
    void receiveCard(Card card){
        hand.addCard(card);
    }

    boolean hasBlackjack(){
        return hand.isInitiallyBlackjack();
    }

    boolean hasDoubleAce(){
        return hand.isInitiallyDoubleAce();
    }

    boolean hasBustedHand(){
        return hand.busted();
    }

    int score(){
        return hand.score();
    }


    @Override
    public String toString(){
        return name + ": " + hand;
    }

}
