package backend.academy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class HangmanGameTest {

    private HangmanGame game;
    private UserInterface ui;
    private ConsoleIO mockConsoleIO;

    @BeforeEach
    public void setUp() {
        mockConsoleIO = mock(ConsoleIO.class);
        ui = new UserInterface(mockConsoleIO, new Hangman());
        game = new HangmanGame("apple", ui);
    }

    @Test
    public void testCorrectLetterGuess() {
        when(mockConsoleIO.readLine()).thenReturn("a", "p", "l", "e");
        game.startGame();
        verify(mockConsoleIO, times(4)).readLine();
    }

    @Test
    public void testIncorrectLetterGuess() {
        when(mockConsoleIO.readLine()).thenReturn("z", "x", "y", "w", "v", "u", "t");
        game.startGame();  // Запуск игры
        verify(mockConsoleIO, times(7)).readLine();
    }

    @Test
    public void testWinGame() {
        when(mockConsoleIO.readLine()).thenReturn("a", "P", "l", "e");
        game.startGame();  // Запуск игры
        verify(mockConsoleIO, times(4)).readLine();
    }

    @Test
    public void testLoseGame() {
        when(mockConsoleIO.readLine()).thenReturn("z", "x", "Y", "w", "v", "u", "t");
        game.startGame();  // Запуск игры
        verify(mockConsoleIO, times(7)).readLine();
    }
}
