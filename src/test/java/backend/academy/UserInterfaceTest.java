package backend.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserInterfaceTest {

    private UserInterface userInterface;
    private ConsoleIO mockConsoleIO;

    @BeforeEach
    public void setUp() {
        mockConsoleIO = mock(ConsoleIO.class);  // Мокируем ConsoleIO
        userInterface = new UserInterface(mockConsoleIO, new Hangman());  // Передаем мок в UserInterface
    }

    @Test
    public void testRequestLetterValidInput() {
        when(mockConsoleIO.readLine()).thenReturn("a");  // Мокируем ввод через ConsoleIO
        char letter = userInterface.requestLetter();
        assertEquals('a', letter);
    }

    @Test
    public void testRequestLetterInvalidThenValidInput() {
        when(mockConsoleIO.readLine()).thenReturn("1", "ab", "c");  // Несколько вызовов readLine
        char letter = userInterface.requestLetter();
        assertEquals('c', letter);
    }

    @Test
    public void testRequestDifficultyValidInput() {
        when(mockConsoleIO.readLine()).thenReturn("easy");
        DifficultyLevels difficulty = userInterface.requestDifficulty();
        assertEquals(DifficultyLevels.EASY, difficulty);
    }

    @Test
    public void testRequestDifficultyInvalidThenValidInput() {
        when(mockConsoleIO.readLine()).thenReturn("beginner", "hard");
        DifficultyLevels difficulty = userInterface.requestDifficulty();
        assertEquals(DifficultyLevels.HARD, difficulty);
    }

    @Test
    public void testRequestCategoryValidInput() {
        when(mockConsoleIO.readLine()).thenReturn("animals");
        String category = userInterface.requestCategory();
        assertEquals("animals", category);
    }

    @Test
    public void testRequestCategoryInvalidThenValidInput() {
        when(mockConsoleIO.readLine()).thenReturn("cars", "fruits");
        String category = userInterface.requestCategory();
        assertEquals("fruits", category);
    }

}
