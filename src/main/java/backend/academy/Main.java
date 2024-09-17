package backend.academy;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        HangmanGameLauncher launcher = new HangmanGameLauncher();
        launcher.setUpAndStartGame();
    }
}
