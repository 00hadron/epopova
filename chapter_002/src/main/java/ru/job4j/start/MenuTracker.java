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
class EditItem extends BaseAction {

    public EditItem(int key, String name) {
        super(key, name);
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
}

public class MenuTracker {
    private UserAction[] action = new UserAction[7];
    private int[] range = new int[action.length];
    private Tracker tracker;
    private Input input;
    private int position = 0;

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

        this.action[this.position] = this.new AddItem(this.position++, "Add new Item");
        this.action[this.position] = new MenuTracker.ShowItem(this.position++, "Show all items");
        this.action[this.position] = new EditItem(this.position++, "Edit item");
        this.action[this.position] = new DeleteItem(this.position++, "Delete item");
        this.action[this.position] = new FindByIdItem(this.position++, "Find item by Id");
        this.action[this.position] = new FindByNameItem(this.position++, "Find items by name");
        this.action[this.position] = new ExitProgram(this.position++, "Exit program");
        this.fillRange();
    }

    /**
     * Метод select - запускает дейстие по ключу.
     * @param key
     *
     */
    public void select(int key) {
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
    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---Добавление новой заявки---");
            String name  = input.ask("введите имя заявки : ");
            String desc = input.ask("введите описание заявки : ");
            Item item = new Item(name, desc);
            tracker.add(item);
        }
    }

    /**
     * Внутренний статический класс ShowItem - показ всех заявок.
     */
    private static class ShowItem extends BaseAction {

        public ShowItem(int key, String name) {
            super(key, name);
        }
        @Override
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
    }
    /**
     * Внутренний динамический класс DeleteItem - удаление заявки\заявок по имени.
     */
    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
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
    }
    /**
     * Внутренний динамический класс FindByIdItem - поиск заявки по ID.
     */
    private class FindByIdItem extends BaseAction {

        public FindByIdItem(int key, String name) {
            super(key, name);
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
    }

    /**
     * Внутренний динамический класс FindByNameItem - поиск заявки по имени.
     */
    private class FindByNameItem extends BaseAction {

        public FindByNameItem(int key, String name) {
            super(key, name);
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
    }

    private class ExitProgram extends BaseAction {

        public ExitProgram(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("--- Выход из программы ---");
        }
    }
}
