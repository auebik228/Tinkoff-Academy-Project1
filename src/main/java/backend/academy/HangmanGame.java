package backend.academy;

public class HangmanGame {
    private final GameState gameState;
    private final UserInterface ui;
    private final int hintThreshold = 3;

    public HangmanGame(WordWithHint wordWithHint, UserInterface ui) {
        this.ui = ui;
        this.gameState = new GameState(wordWithHint);
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
                gameState.revealLetter(guessedLetter);
                ui.congratulateForLetter(guessedLetter, String.valueOf(gameState.getKnownPartOfWord()));
            } else {
                gameState.incrementAttempts();
                ui.displayHangman(gameState.getAttemptsLeft(), gameState.getMaxAttempts());

                if (!gameState.isHintShown()
                    && (gameState.getMaxAttempts() - gameState.getAttemptsLeft()) == hintThreshold) {
                    ui.showHint(gameState.getHint());
                    gameState.showHint();
                }
            }
        }

        if (gameState.isMaxAttemptsReached()) {
            ui.lose(String.valueOf(gameState.getWord()));
        } else {
            ui.win(String.valueOf(gameState.getWord()));
        }
    }

    private boolean guessLetter(char guessedLetter) {
        for (char c : gameState.getWord()) {
            if (c == guessedLetter) {
                return true;
            }
        }
        return false;
    }
}
