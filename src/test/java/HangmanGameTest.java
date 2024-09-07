import backend.academy.HangmanGame;
import backend.academy.UserInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.mockito.Mockito.*;

public class HangmanGameTest {

    private HangmanGame game;
    private UserInterface ui;
    private Scanner mockScanner;

    @BeforeEach
    public void setUp() {
        // Создаем мок для Scanner
        mockScanner = mock(Scanner.class);
        // Создаем UserInterface с замоканным Scanner
        ui = new UserInterface(mockScanner);
        // Создаем игру с загаданным словом "apple" и 7 попытками
        game = new HangmanGame("apple", 7, ui);
    }

    @Test
    public void testCorrectLetterGuess() {
        when(mockScanner.nextLine()).thenReturn("a", "p", "l", "e");
        game.startGame();
        verify(mockScanner, times(4)).nextLine(); //
    }

    @Test
    public void testIncorrectLetterGuess() {
        when(mockScanner.nextLine()).thenReturn("z", "x", "y", "w", "v", "u", "t");
        game.startGame();
        verify(mockScanner, times(7)).nextLine(); // Проверяем, что ввод был запрошен 7 раз
    }

    @Test
    public void testWinGame() {
        when(mockScanner.nextLine()).thenReturn("a", "P", "l", "e");
        game.startGame();
        verify(mockScanner, times(4)).nextLine();
    }

    @Test
    public void testLoseGame() {
        when(mockScanner.nextLine()).thenReturn("z", "x", "Y", "w", "v", "u", "t");
        game.startGame();
        verify(mockScanner, times(7)).nextLine(); // Проверяем, что ввод был запрошен 7 раз
    }
}
