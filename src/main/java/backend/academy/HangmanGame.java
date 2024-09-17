package backend.academy;

public class HangmanGame {
    private final GameState gameState;
    private final UserInterface ui;

    public HangmanGame(String word, UserInterface ui) {
        this.ui = ui;
        this.gameState = new GameState(word);
    }

    public void startGame() {
        ui.startGame();
        while (!gameState.isWordGuessed() && !gameState.isMaxAttemptsReached()) {
            char guessedLetter = ui.requestLetter();

            if (gameState.getGuessedLetters().contains(guessedLetter)) {
                ui.repeatLetter(guessedLetter);
                continue;
            }

            gameState.addGuessedLetter(guessedLetter);
            boolean isCorrect = guessLetter(guessedLetter);
            if (isCorrect) {
                gameState.revealLetter(guessedLetter); // Передаём букву для раскрытия
                ui.congratulateForLetter(guessedLetter, String.valueOf(gameState.getKnownPartOfWord()));
            } else {
                gameState.decrementAttempts(); // Уменьшаем количество оставшихся попыток
                ui.displayHangman(gameState.getAttemptsLeft(), gameState.getMaxAttempts());
            }
        }

        if (gameState.isMaxAttemptsReached()) {
            ui.lose(String.valueOf(gameState.getWord()));
        } else {
            ui.win(String.valueOf(gameState.getWord()));
        }
    }

    private boolean guessLetter(char guessedLetter) {
        boolean isCorrect = false;
        for (char c : gameState.getWord()) {
            if (c == guessedLetter) {
                isCorrect = true;
                break;
            }
        }
        return isCorrect;
    }
}
