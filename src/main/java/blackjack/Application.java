package blackjack;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        Game game;
        try {
            game = new Game(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            game = new Game();
        }

        game.simulateGame();
    }
}