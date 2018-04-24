package ru.job4j.start;
import java.util.*;

/**
 * Класс ConsoleInput для получения ответов пользователя из консоли.
 * @author epopova
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * @param question вопрос пользователю.
     * @return ответ пользователя из консоли.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
