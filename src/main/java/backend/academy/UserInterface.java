package backend.academy;

import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }


    public char requestLetter() {
        while (true) {
            System.out.println("Введите букву: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                return input.charAt(0);
            } else {
                System.out.println("Ошибка: введите одну букву.");
            }
        }
    }


    public String requestDifficulty() {
        while (true) {
            System.out.print("Выберите уровень сложности (easy, medium, hard): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("easy") || input.equals("medium") || input.equals("hard")) {
                return input;
            } else {
                System.out.println("Ошибка: выберите один из уровней сложности: easy, medium, hard.");
            }
        }
    }

    public String requestCategory() {
        while (true) {
            System.out.print("Выберите категорию (animals, fruits, countries): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("animals") || input.equals("fruits") || input.equals("countries")) {
                return input;
            } else {
                System.out.println("Ошибка: выберите одну из категорий: animals, fruits, countries.");
            }
        }
    }


    public void congratulateForLetter(char letter, String knownPartOfWord) {
        System.out.println("Поздравляем! Вы угадали букву: " + letter + System.lineSeparator() +
                "Отгаданная часть слова - " + knownPartOfWord);
    }


    public void congratulateForWord(String word) {
        System.out.println("Поздравляем! Вы угадали слово: " + word);
    }

    public void displayHangman(int attemptsLeft) {

        String[] hangmanStages = {
                """
               ------
               |    |
               |
               |
               |
               |
            --------
            """,
                """
               ------
               |    |
               |    O
               |
               |
               |
            --------
            """,
                """
               ------
               |    |
               |    O
               |    |
               |
               |
            --------
            """,
                """
               ------
               |    |
               |    O
               |   /|
               |
               |
            --------
            """,
                """
               ------
               |    |
               |    O
               |   /|\\
               |
               |
            --------
            """,
                """
               ------
               |    |
               |    O
               |   /|\\
               |   /
               |
            --------
            """,
                """
               ------
               |    |
               |    O
               |   /|\\
               |   / \\
               |
            --------
            """
        };
        System.out.println(hangmanStages[attemptsLeft]);
    }
    public void promt(){
        System.out.println(">>");
    }

}
