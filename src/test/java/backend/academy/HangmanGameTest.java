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
        game = new HangmanGame(new WordWithHint("apple", "Круглый фрукт, часто используемый в пирогах."), ui);
    }

    @Test
    public void testCorrectLetterGuess() {

        when(mockConsoleIO.readLine()).thenReturn("a", "p", "l", "e");

        game.startGame();


        verify(mockConsoleIO, times(4)).readLine();


        verify(mockConsoleIO).println("Вы победили, загаданное слово - apple");
    }

    @Test
    public void testIncorrectLetterGuess() {

        when(mockConsoleIO.readLine()).thenReturn("z", "x", "y", "w", "v", "u", "t");

        game.startGame();


        verify(mockConsoleIO, times(7)).readLine();


        verify(mockConsoleIO).println("Вы проиграли, загаданное слово - apple");
    }

    @Test
    public void testWinGame() {

        when(mockConsoleIO.readLine()).thenReturn("a", "P", "l", "e");

        game.startGame();


        verify(mockConsoleIO, times(4)).readLine();


        verify(mockConsoleIO).println("Вы победили, загаданное слово - apple");
    }

    @Test
    public void testLoseGame() {

        when(mockConsoleIO.readLine()).thenReturn("z", "x", "Y", "w", "v", "u", "t");

        game.startGame();


        verify(mockConsoleIO, times(7)).readLine();


        verify(mockConsoleIO).println("Вы проиграли, загаданное слово - apple");
    }

    @Test
    public void testHintShownAfterThreshold() {

        when(mockConsoleIO.readLine()).thenReturn("z", "x", "y","q","w", "a", "p", "l", "e");

        game.startGame();


        verify(mockConsoleIO, times(9)).readLine();


        verify(mockConsoleIO).println("Подсказка: Круглый фрукт, часто используемый в пирогах.");


        verify(mockConsoleIO).println("Вы победили, загаданное слово - apple");
    }

    @Test
    public void testHintShownOnlyOnce() {

        when(mockConsoleIO.readLine()).thenReturn("z", "x", "y", "w", "v", "u", "t");

        game.startGame();


        verify(mockConsoleIO, times(7)).readLine();


        verify(mockConsoleIO, times(1)).println("Подсказка: Круглый фрукт, часто используемый в пирогах.");

        verify(mockConsoleIO).println("Вы проиграли, загаданное слово - apple");
    }


}
