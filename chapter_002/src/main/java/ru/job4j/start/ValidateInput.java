package ru.job4j.start;

/**
 * Класс ValidateInput обработка исключительных ситуаций.
 * @author epopova
 */
public class ValidateInput extends ConsoleInput {

    /**
     * Обрабатывает исключения.
     */
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
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

}
