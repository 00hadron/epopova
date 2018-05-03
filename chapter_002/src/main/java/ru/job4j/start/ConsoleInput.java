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

    /**
     * Проверяет, что ответ пользователя в допустимом диапазоне.
     * Иначе выкидывает исключение.
     * @param question вопрос пользователю.
     * @param range диапазон значений
     * @return key
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean flag = false;
        for (int value : range) {
            if (value == key) {
                flag = true;
                break;
            }
        }
        if (flag) {
            return key;
        } else {
            throw new MenuOutException("вне диапазона меню!");
        }
    }
}