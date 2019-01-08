package util;

import blackjack.Card;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CardUtil {
    private final static Logger logger = LoggerFactory.getLogger(CardUtil.class.getName());

    public static String printCards(List<Card> cards) {
        return cards.stream()
                .map(c -> c.uniqueCardId() + ", ")
                .reduce("", String::concat)
                .replaceAll(", $", "");
    }

    public static String readCardListFromFile(String fileName){
        if(StringUtils.isBlank(fileName)){
            logger.info("No file name provided.");
            return null;
        }

        try {
            File resource =  new ClassPathResource(fileName).getFile();
            return new String(Files.readAllBytes(resource.toPath()));
        } catch (IOException e) {
            logger.error("Something went wrong when reading the file");
            e.printStackTrace();
            return null;
        }

    }
}
