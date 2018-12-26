package blackjack;

public class Card {
    private char suit;
    private String rank;

    Card(char suit, String rank){
        this.suit = suit;
        this.rank = rank;
    }

    public String uniqueCardId(){
        return suit + rank;
    }
}
