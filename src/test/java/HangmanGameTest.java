import backend.academy.HangmanGame;
import backend.academy.UserInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class HangmanGameTest {

    private HangmanGame game;
    private UserInterface ui;

    @BeforeEach
    public void setUp() {
        ui = mock(UserInterface.class); // Используем мок для UserInterface
        game = new HangmanGame("apple", 7, ui); // Пример игры со словом "apple" и 7 попытками
    }

    @Test
    public void testCorrectLetterGuess() {
        when(ui.requestLetter()).thenReturn('a', 'p','l', 'e'); // Ввод последовательности букв для завершения игры
        game.startGame();
        verify(ui).congratulateForLetter('a', "a____");
    }

    @Test
    public void testIncorrectLetterGuess() {
        when(ui.requestLetter()).thenReturn('z', 'x', 'y', 'w', 'v', 'u', 't'); // Пользователь вводит неправильные буквы
        game.startGame();
        verify(ui).displayHangman(0, 7);
    }

    @Test
    public void testWinGame() {
        when(ui.requestLetter()).thenReturn('a', 'p', 'l', 'e'); // Пользователь вводит все правильные буквы
        game.startGame();
        verify(ui).win("apple");
    }

    @Test
    public void testLoseGame() {
        when(ui.requestLetter()).thenReturn('z', 'x', 'y', 'w', 'v', 'u', 't'); // Пользователь вводит неправильные буквы
        game.startGame();
        verify(ui).lose("apple");
    }
}
