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
            promt();
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
            System.out.println("Выберите уровень сложности (easy, medium, hard) или нажмите enter для случайного выбора: ");
            promt();
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("easy") || input.equals("medium") || input.equals("hard") || input.isEmpty()) {
                return input;
            } else {
                System.out.println("Ошибка: выберите один из уровней сложности: easy, medium, hard ");
            }
        }
    }

    public String requestCategory() {
        while (true) {
            System.out.println("Выберите категорию (animals, fruits, countries) или нажмите enter для случайного выбора: ");
            promt();
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("animals") || input.equals("fruits") || input.equals("countries") || input.isEmpty()) {
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


    public void displayHangman(int attemptsLeft,int maxattempts) {
        System.out.println("К сожалению буква неверная,"+ "вы можете ошибиться еще " + (maxattempts-attemptsLeft-1) + " раз" + System.lineSeparator() +
                " Cостояние висельника:");
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

    public void promt() {
        System.out.print(">>");
    }

    public void startGame() {
        System.out.println("Игра началась");
    }

    public void lose(String word) {
        System.out.println("Вы проиграли, загаданное слово - " + word);
    }

    public void win(String word) {
        System.out.println("Вы победили, загаданное слово - " + word);
    }
    public void repeatLetter(Character c) {
        System.out.println("Вы уже пробовали букву "+ c+", попробуйте другую");
    }
    public void startProgram(){
        System.out.println("Консольная игра Висельник начала свою работу");
    }
    public void remindGameSettings(String difficulty,String category) {
        System.out.println();
    }


}
