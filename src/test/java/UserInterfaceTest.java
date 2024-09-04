

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import backend.academy.UserInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class UserInterfaceTest {

    private UserInterface userInterface;
    private Scanner mockScanner;

    @BeforeEach
    public void setUp() {
        mockScanner = mock(Scanner.class);
        userInterface = new UserInterface(mockScanner);
    }

    @Test
    public void testRequestLetterValidInput() {
        when(mockScanner.nextLine()).thenReturn("a");
        char letter = userInterface.requestLetter();
        assertEquals('a', letter);
    }

    @Test
    public void testRequestLetterInvalidThenValidInput() {
        when(mockScanner.nextLine()).thenReturn("1", "ab", "c");
        char letter = userInterface.requestLetter();
        assertEquals('c', letter);
    }

    @Test
    public void testRequestDifficultyValidInput() {
        when(mockScanner.nextLine()).thenReturn("easy");
        String difficulty = userInterface.requestDifficulty();
        assertEquals("easy", difficulty);
    }

    @Test
    public void testRequestDifficultyInvalidThenValidInput() {
        when(mockScanner.nextLine()).thenReturn("beginner", "hard");
        String difficulty = userInterface.requestDifficulty();
        assertEquals("hard", difficulty);
    }

    @Test
    public void testRequestCategoryValidInput() {
        when(mockScanner.nextLine()).thenReturn("animals");
        String category = userInterface.requestCategory();
        assertEquals("animals", category);
    }

    @Test
    public void testRequestCategoryInvalidThenValidInput() {
        when(mockScanner.nextLine()).thenReturn("cars", "fruits");
        String category = userInterface.requestCategory();
        assertEquals("fruits", category);
    }

}
