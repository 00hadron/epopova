package ru.job4j.start;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * Класс MenuTracker - реализация событий для класса StartUI, интрефейса UserAction с использоваинем внутр. и внешн. классов.
 * @author epopova
 * @since 01.05.2018
 */

/**
 * Внешний default класс EditItem - редактирование заявки.
 */
class EditItem implements UserAction {

    public int key() {
        return 2;
    }

    public void execute(Input input, Tracker tracker) {
        System.out.println("---Редактирование заявки---");
        String name = input.ask("введите имя заявки для редактирования : ");
        String nextName = input.ask("Обновите имя заявки : ");
        String nextDesc = input.ask("Обновите desc : ");
        Item item = new Item(nextName, nextDesc);
        tracker.add(item);
        Item[] items = tracker.findByName(name);
        int number = 1;
        for (Item element : items) {
            System.out.print(number + ". name --- " + element.getName() + " ---; (ID " + element.getId() + "); desc --- " + element.getDesc());
            number++;
            tracker.replace(element.getId(), item);
            System.out.println("/ обновление заявки: name --- " + item.getName() + "; new desc --- " + item.getDesc());
        }
        if (items.length == 0) {
            System.out.println("ххх ничего не найдено! ххх");
        }
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Edit item");
    }
}

public class MenuTracker {
    private UserAction[] action = new UserAction[7];
    private int[] range = new int[action.length];
    private Tracker tracker;
    private Input input;



    /**
     * Конструктор для инициализации полей класса.
     * @param input
     * @param tracker
     */

    public MenuTracker(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }

    /**
     * Геттер поля диапазон допустимых ответов.
     * @return массив допустимых ответов.
     */
    public int[] getRange() {
        return this.range;
    }

    /**
     * Заполняет массив допустимых ответов.
     */
    private void fillRange() {
        for (int index = 0; index != range.length; index++) {
            this.range[index] = index;
        }
    }

    /**
     * Метод FillAction заполняет массив возможных действий пользователя.
     */
    public void fillActions() {

        this.action[0] = this.new AddItem();
        this.action[1] = new MenuTracker.ShowItem();
        this.action[2] = new EditItem();
        this.action[3] = new DeleteItem();
        this.action[4] = new FindByIdItem();
        this.action[5] = new FindByNameItem();
        this.action[6] = new ExitProgram();
        this.fillRange();
    }

    /**
     * Метод select - запускает дейстие по ключу.
     * @param key
     * @param range
     */
    public void select(int key, int[] range) {
        this.action[key].execute(this.input, this.tracker);
    }

    /**
     * Метод show - показывает в консоли все возможные действия списком.
     */
    public void show() {
        for (int index = 0; index != action.length; index++) {
            if (action[index] != null) {
                System.out.println(action[index].info());
            }
        }
    }

    /**
     * Внутренний динамический класс AddItem - добавление новой заявки.
     */
    private class AddItem implements UserAction {

        public int key() {
            return 0;
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("---Добавление новой заявки---");
            String name  = input.ask("введите имя заявки : ");
            String desc = input.ask("введите описание заявки : ");
            Item item = new Item(name, desc);
            tracker.add(item);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add new Item");
        }
    }

    /**
     * Внутренний статический класс ShowItem - показ всех заявок.
     */
    private static class ShowItem implements UserAction {

        public int key() {
            return 1;
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("--- Сейчас покажу все items... ---");
            int number = 1;
            for (Item items : tracker.findAll()) {
                System.out.println(number + ". name " + items.getName() + "; desc " + items.getDesc());
                number++;
            }
            if (tracker.findAll().length == 0) {
                System.out.println("ххх ничего не найдено! ххх");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }
    /**
     * Внутренний динамический класс DeleteItem - удаление заявки\заявок по имени.
     */
    private class DeleteItem implements UserAction {

        public int key() {
            return 3;
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("---Удаление заявок с именем---");
            String name = input.ask("введите имя заявки : ");
            Item[] result = tracker.findByName(name);
            int number = 1;
            for (Item element : result) {
                tracker.delete(element.getId());
                System.out.println(number + ". удалена заявка ---> name " + element.getName() + "; ID " + element.getId());
                number++;
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }
    /**
     * Внутренний динамический класс FindByIdItem - поиск заявки по ID.
     */
    private class FindByIdItem implements UserAction {
        public int key() {
            return 4;
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("--- Найдем заявку по ID заявки ---");
            String id = input.ask("введите ID заявки : ");
            Item result = tracker.findById(id);
            int number = 1;
            if (result != null) {
                System.out.println(number + ". заявка с таким ID --- " + result.getName() + " ---");
            } else {
                System.out.println("ххх ничего не найдено! ххх");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id");
        }
    }
    /**
     * Внутренний динамический класс FindByNameItem - поиск заявки по имени.
     */
    private class FindByNameItem implements UserAction {

        public int key() {
            return 5;
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("--- Найдем заявки по имени ---");
            String name = input.ask("введите имя заявки : ");
            Item[] result = tracker.findByName(name);
            int number = 1;
            for (Item element : result) {
                System.out.println(number + ". name --- " + element.getName() + " ---; ID --- " + element.getId() + " ---");
                number++;
            }
            if (result.length == 0) {
                System.out.println("ххх ничего не найдено! ххх");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }
    }

    private class ExitProgram implements UserAction {
        public int key() {
            return 6;
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("--- Выход из программы ---");
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Exit program");
        }
    }
}
