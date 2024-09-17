package backend.academy;

public class HangmanGameLauncher {
    public void setUpAndStartGame() {
        WordDictionary dict = new WordDictionary();
        UserInterface ui = new UserInterface(new ConsoleIO(System.in, System.out), new Hangman());
        ui.startProgram();
        DifficultyLevels difficulty = ui.requestDifficulty();
        String category = ui.requestCategory();
        String word = dict.getRandomWord(difficulty, category);

        HangmanGame hangmanGame = new HangmanGame(word, ui);
        hangmanGame.startGame();
    }
}
