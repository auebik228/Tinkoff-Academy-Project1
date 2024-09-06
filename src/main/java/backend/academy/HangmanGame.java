package backend.academy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HangmanGame {
    char[] word;
    char[] knownPartOfWord;
    private int maxAttempts;
    private int attemptsLeft;
    private Set<Character> guessedLetters;
    private UserInterface ui;
    public HangmanGame(String word, int maxAttempts, UserInterface ui) {
        this.ui = ui;
        this.word = word.toLowerCase().toCharArray();
        this.knownPartOfWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            knownPartOfWord[i] = '_';
        }
        this.maxAttempts = maxAttempts;
        this.attemptsLeft = 0;
        this.guessedLetters = new HashSet<>();
    }
    public void startGame(){
        ui.startGame();
        while (attemptsLeft < maxAttempts && !Arrays.equals(word, knownPartOfWord)) {
            char guessedLetter = ui.requestLetter();
            if (guessedLetters.contains(guessedLetter)) {
                ui.repeatLetter(guessedLetter);
                continue;
            }else{
                guessedLetters.add(guessedLetter);
            }
            boolean isLetterCorrect = guess(guessedLetter);
            if (isLetterCorrect) {
                ui.congratulateForLetter(guessedLetter, String.valueOf(knownPartOfWord));
            }else{
                ui.displayHangman(attemptsLeft,maxAttempts);
                attemptsLeft++;
            }
        }
        if (attemptsLeft == maxAttempts) {
            ui.lose(String.valueOf(word));
        }else{
            ui.win(String.valueOf(word));
        }
    }
    public boolean guess(char guessedLetter){
        int countOfOpenLetters = 0;
        for (int i = 0; i < word.length; i++) {
            if (word[i] == guessedLetter) {
                countOfOpenLetters++;
                knownPartOfWord[i] = guessedLetter;
            }
        }
        return countOfOpenLetters > 0;
    }
}
