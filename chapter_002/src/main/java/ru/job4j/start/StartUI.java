package ru.job4j.start;
import ru.job4j.tracker.*;

/**
 * Класс StartUI для запуска программы и опроса пользователя.
 * @author epopova
 */
public class StartUI {
    private final Input input;
    private final Tracker tracker;

    /**
     * Конструкторы инициализации полей класса.
     * @param input - получение данных от пользователя.
     * @param tracker - хранение заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }


    /**
     * main.
     * @param args
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI(input, tracker);
        startUI.init();
    }

    /**
     * опрос пользователя.
     */
    protected void init() {

        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        String answer;
        do {
            menu.show();
            menu.select(input.ask("введите пункт меню (от 0 до 6) : ", menu.getRange()));
            answer = this.input.ask("exit? (y): ");
        } while (!"y".equals(answer));
    }
}

