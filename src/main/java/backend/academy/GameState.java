package backend.academy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameState {
    private final char[] word;
    private final char[] knownPartOfWord;
    private final int maxAttempts = 7;
    private int attemptsLeft;
    private final Set<Character> guessedLetters;

    public GameState(String word) {
        this.word = word.toLowerCase().toCharArray();
        this.knownPartOfWord = new char[word.length()];
        Arrays.fill(this.knownPartOfWord, '_');
        this.attemptsLeft = 0; // Изначально доступно maxAttempts
        this.guessedLetters = new HashSet<>();
    }

    public char[] getWord() {
        return word;
    }

    public char[] getKnownPartOfWord() {
        return knownPartOfWord;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public void decrementAttempts() {
        this.attemptsLeft++;
    }

    public Set<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public void addGuessedLetter(char letter) {
        guessedLetters.add(letter);
    }

    public boolean isWordGuessed() {
        return Arrays.equals(word, knownPartOfWord);
    }

    public boolean isMaxAttemptsReached() {
        return attemptsLeft == maxAttempts;
    }

    public void revealLetter(char letter) {
        for (int i = 0; i < word.length; i++) {
            if (word[i] == letter) {
                knownPartOfWord[i] = letter;
            }
        }
    }
}
