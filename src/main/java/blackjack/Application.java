package blackjack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;


@SpringBootApplication
public class Application {
	@Value("${input.file}")
	private static String inputFile;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println(inputFile);
        Game game = new Game(inputFile);
        game.simulateGame();
    }
}