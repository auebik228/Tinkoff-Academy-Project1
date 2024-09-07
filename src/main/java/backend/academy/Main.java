package backend.academy;

import lombok.experimental.UtilityClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        Scanner sc = new Scanner(System.in);
        UserInterface ui = new UserInterface(sc);

        ui.startProgram();
        String diffilty = ui.requestDifficulty();
        String category = ui.requestCategory();
        String word = dict.getRandomWord(diffilty, category);

        HangmanGame game = new HangmanGame(word,7,ui);
        game.startGame();
    }
}
