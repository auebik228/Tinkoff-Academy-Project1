package backend.academy;

public class UserInterface {

    private final ConsoleIO consoleIO;
    private final Hangman hangman;

    public UserInterface(ConsoleIO consoleIO, Hangman hangman) {
        this.consoleIO = consoleIO;
        this.hangman = hangman;
    }

    public char requestLetter() {
        while (true) {
            consoleIO.println("Введите букву: ");
            consoleIO.prompt();
            String input = consoleIO.readLine().toLowerCase();
            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                return input.charAt(0);
            } else {
                consoleIO.println("Ошибка: введите одну букву.");
            }
        }
    }

    public void showHint(String hint) {
        consoleIO.println("Подсказка: " + hint);
    }

    public DifficultyLevels requestDifficulty() {
        while (true) {
            consoleIO.println("Выберите уровень сложности easy, medium, hard или none для случайного выбора: ");
            consoleIO.prompt();
            String input = consoleIO.readLine().toUpperCase();

            if (input.equals("EASY") || input.equals("MEDIUM") || input.equals("HARD") || input.equals("NONE")) {
                return DifficultyLevels.valueOf(input);
            } else {
                consoleIO.println("Ошибка: выберите один из уровней сложности: easy, medium, hard, none ");
            }
        }
    }

    public String requestCategory() {
        while (true) {
            consoleIO.println("Выберите категорию animals, fruits, countries или none для случайного выбора: ");
            consoleIO.prompt();
            String input = consoleIO.readLine().toLowerCase();

            if (input.equals("animals") || input.equals("fruits") || input.equals("countries") || input.isEmpty()) {
                return input;
            } else {
                consoleIO.println("Ошибка: выберите одну из категорий: animals, fruits, countries.");
            }
        }
    }

    public void congratulateForLetter(char letter, String knownPartOfWord) {
        consoleIO.println("Поздравляем! Вы угадали букву: " + letter + System.lineSeparator()
            + "Отгаданная часть слова - " + knownPartOfWord);
    }

    public void displayHangman(int attemptsLeft, int maxAttempts) {
        consoleIO.println("К сожалению буква неверная, вы можете ошибиться еще " + (maxAttempts - attemptsLeft) + " раз"
            + System.lineSeparator() + "Состояние висельника:");
        consoleIO.println(hangman.getHangmanStage(attemptsLeft - 1));
    }

    public void startGame() {
        consoleIO.println("Игра началась");
    }

    public void lose(String word) {
        consoleIO.println("Вы проиграли, загаданное слово - " + word);
    }

    public void win(String word) {
        consoleIO.println("Вы победили, загаданное слово - " + word);
    }

    public void repeatLetter(Character c) {
        consoleIO.println("Вы уже пробовали букву " + c + ", попробуйте другую");
    }

    public void startProgram() {
        consoleIO.println("Консольная игра Висельник начала свою работу");
    }

    public void remindGameSettings(String difficulty, String category) {
        consoleIO.println("Настройки игры: уровень сложности - " + difficulty + ", категория - " + category);
    }
}
