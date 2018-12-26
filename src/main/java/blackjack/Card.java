package blackjack;

public class Card {
    private char suit;
    private String rank;

    Card(char suit, String rank){
        this.suit = suit;
        this.rank = rank;
    }

    Card(String uniqueCardId){
        this.suit = uniqueCardId.charAt(0);
        this.rank = uniqueCardId.substring(1);
    }

    public String uniqueCardId(){
        return suit + rank;
    }
}
