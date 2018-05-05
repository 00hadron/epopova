package ru.job4j.start;

import java.util.Scanner;

/**
 * Класс ValidateInput обработка исключительных ситуаций.
 * concrete decorator class extending the InputDecorator class.
 * @author epopova
 */
public class ValidateInput extends InputDecorator {
    private Scanner scanner = new Scanner(System.in);

    public ValidateInput(final Input decoratedInput ) {
        super(decoratedInput);
    }
    /**
     * Обрабатывает исключения.
     */
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.decoratedInput.ask(question, range);
                invalid = false;
            }catch (MenuOutException moe) {
                System.out.println("выберите ключ из меню");
            }

            catch (NumberFormatException nfe) {
                System.out.println("введите корректные данные!");
            }
        } while (invalid);
        return value;
    }

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
