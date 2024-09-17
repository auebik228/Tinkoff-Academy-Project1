package backend.academy;

import lombok.experimental.UtilityClass;
import org.checkerframework.checker.units.qual.C;

import java.util.Scanner;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        HangmanGameLauncher launcher = new HangmanGameLauncher();
        launcher.setUpAndStartGame();
    }
}
