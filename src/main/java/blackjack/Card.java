package blackjack;

import static blackjack.Rank.ACE;
import static blackjack.Rank.EIGHT;
import static blackjack.Rank.FIVE;
import static blackjack.Rank.FOUR;
import static blackjack.Rank.JACK;
import static blackjack.Rank.KING;
import static blackjack.Rank.NINE;
import static blackjack.Rank.QUEEN;
import static blackjack.Rank.SEVEN;
import static blackjack.Rank.SIX;
import static blackjack.Rank.TEN;
import static blackjack.Rank.THREE;
import static blackjack.Rank.TWO;
import static blackjack.Suit.CLUBS;
import static blackjack.Suit.DIAMONDS;
import static blackjack.Suit.HEARTS;
import static blackjack.Suit.SPADES;

public class Card {
    private Suit suit;
    private Rank rank;

    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    Card(String uniqueCardId) {
        this.suit = convertCharToSuit(uniqueCardId.charAt(0));
        this.rank = convertStringToRank(uniqueCardId.substring(1));
    }

    public String uniqueCardId() {
        return suit.suitAcronym() + rank.value();
    }

    public int point(){
        switch (this.rank){
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
            case JACK:
            case QUEEN:
            case KING:
                return 10;
            case ACE:
                return 11;
            default:
                throw new IllegalArgumentException("Illegal card");

        }
    }

    private Suit convertCharToSuit(char suitAcronym) {
        switch (suitAcronym) {
            case 'C':
                return CLUBS;
            case 'D':
                return DIAMONDS;
            case 'H':
                return HEARTS;
            case 'S':
                return SPADES;
            default:
                throw new IllegalArgumentException("Unknown suit acronym");
        }
    }

    private Rank convertStringToRank(String rankValue) {
        switch (rankValue) {
            case "2":
                return TWO;
            case "3":
                return THREE;
            case "4":
                return FOUR;
            case "5":
                return FIVE;
            case "6":
                return SIX;
            case "7":
                return SEVEN;
            case "8":
                return EIGHT;
            case "9":
                return NINE;
            case "10":
                return TEN;
            case "J":
                return JACK;
            case "Q":
                return QUEEN;
            case "K":
                return KING;
            case "A":
                return ACE;
            default:
                throw new IllegalArgumentException("Unknown rank value");
        }
    }


}

enum Suit {
    CLUBS('C'),
    DIAMONDS('D'),
    HEARTS('H'),
    SPADES('S');

    private char suitAcronym;

    Suit(char suitAcronym) {
        this.suitAcronym = suitAcronym;
    }

    public char suitAcronym() {
        return suitAcronym;
    }

}

enum Rank {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("k"),
    ACE("A");

    private String value;

    Rank(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}