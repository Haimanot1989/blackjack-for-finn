package util;

import blackjack.Card;

public class a {
    public static CardBuilder card = new CardBuilder();

    public static class CardBuilder{
        String cardId;

        CardBuilder(){
            this("CA");
        }

        CardBuilder(String cardId){
            this.cardId = cardId;
        }

        public CardBuilder withCardId(String cardId){
            return new CardBuilder(cardId);
        }

/*        public Card build(){
            return new Card(cardId);
        }*/
    }
}
