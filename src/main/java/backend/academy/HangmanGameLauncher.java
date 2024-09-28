package backend.academy;

public class HangmanGameLauncher {
    public void setUpAndStartGame() {
        WordDictionary dict = new WordDictionary();
        ConsoleIO consoleIO = new ConsoleIO(System.in, System.out);
        Hangman hangman = new Hangman();
        UserInterface ui = new UserInterface(consoleIO, hangman);

        ui.startProgram();
        DifficultyLevels difficulty = ui.requestDifficulty();
        String category = ui.requestCategory();

        WordWithHint wordWithHint = dict.getRandomWord(difficulty, category);

        ui.remindGameSettings(difficulty.toString(), category.isEmpty() ? "none" : category);

        HangmanGame hangmanGame = new HangmanGame(wordWithHint, ui);
        hangmanGame.startGame();
    }
}
