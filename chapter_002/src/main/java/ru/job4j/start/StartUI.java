package ru.job4j.start;
import ru.job4j.tracker.*;

/**
 * Класс StartUI для запуска программы и опроса пользователя.
 * @author epopova
 */
public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private boolean exit = false;

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
        do {
            menu.show();
            String answer = input.ask("введите пункт меню (от 0 до 6) : " );
            int key = Integer.valueOf(answer);
            menu.select(key, menu.getRange());
            if ("6".equals(answer)) {
                answer = this.input.ask("exit? (y): ");
                if ("y".equals(answer)) {
                setExit(true);}
            }
        } while (!this.exit);
    }
}

