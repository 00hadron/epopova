package ru.job4j.start;
import ru.job4j.tracker.*;

/**
 * Класс StartUI для запуска программы и опроса пользователя.
 * (Все массивы заменены на List)
 * @author epopova
 */
public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private boolean exit = false;
    private Integer answer;
    private static final Integer EXIT = 6;

    /**
     * Конструкторы инициализации полей класса.
     * @param input - получение данных от пользователя.
     * @param tracker - хранение заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void setExit(boolean flag) {
        this.exit = flag;
    }

    /**
     * main.
     * @param args
     */
    public static void main(String[] args) {

        Tracker tracker = new Tracker();
        Input input = new ValidateInput(new ConsoleInput());
        StartUI startUI = new StartUI(input, tracker);
        startUI.init();
    }

    /**
     * опрос пользователя.
     */
    protected void init() {

        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            this.answer = this.input.ask("введите пункт меню (от 0 до 6) : ", menu.getRange());
            menu.select(this.answer);
            this.confirm();
        } while (!this.exit);
    }

    /**
     * Переспрашивает пользователя, точно ли надо выйти.
     */
    private void confirm() {

        if (this.EXIT.equals(this.answer)) {
            String answer = this.input.ask("exit? (y): ");
            if ("y".equals(answer)) {
                setExit(true);
            }
        }
    }
}
