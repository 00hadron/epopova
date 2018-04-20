package ru.job4j.start;
import java.util.*;

public class ConsoleInput {
    private Scanner scanner = new Scanner(System.in);

    /**
     *
     * @param question вопрос пользователю.
     * @return ответ пользователя из консоли.
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
