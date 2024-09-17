package backend.academy;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleIO {
    private final Scanner scanner;
    private final PrintStream out;

    // Конструктор для работы с конкретными потоками ввода/вывода
    public ConsoleIO(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    // Метод для вывода строки
    public void println(String message) {
        out.println(message);
    }

    // Метод для вывода строки без перехода на новую строку
    public void print(String message) {
        out.print(message);
    }

    // Метод для чтения строки с консоли
    public String readLine() {
        return scanner.nextLine().trim();
    }

    // Метод для вывода приглашения ввода
    public void prompt() {
        out.print(">> ");
    }
}
