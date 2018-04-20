package ru.job4j.start;
import ru.job4j.tracker.*;

public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDbyID = "4";
    private static final String FINDbyNAME = "5";
    private static final String EXIT = "6";
    private final ConsoleInput input;
    private final Tracker tracker;

    /**
     * Конструкторы инициализации полей класса.
     * @param input - получение данных от пользователя.
     * @param tracker - хранение заявок.
     */
    public StartUI(ConsoleInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * main.
     * @param args
     */
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI(input, tracker);
        startUI.init();
    }

    /**
     * опрос пользователя.
     */
    private void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("введите пункт меню (от 1 до 6) : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.show();
            }else if (EDIT.equals(answer)) {
                this.edit();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDbyID.equals(answer)) {
                this.findByID();
            } else if (FINDbyNAME.equals(answer)) {
                this.findByName();
            }else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Добавить новую заявку.
     */
    private void createItem() {
        System.out.println("---Добавление новой заявки---");
        String name = this.input.ask("введите имя заявки : ");
        String desc = this.input.ask("введите описание заявки : ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println(" ----- новая заявка с Id : " + item.getId() + " ----");
    }

    /**
     * Показать все заявки.
     */
    private void show() {
        System.out.println("--- Сейчас покажу все items... ---");
        int number = 1;
        for (Item items : this.tracker.findAll() ) {
            System.out.println(number + ". name " + items.getName() + "; desc " + items.getDesc());
            number++;
        }
        if (this.tracker.findAll().length == 0) {
            System.out.println("ххх ничего не найдено! ххх");
        }
    }

    /**
     * Редактировать заявку\заявки с именем по имени.
     */
    private void edit() {
        System.out.println("---Редактирование заявки---");
        String name = this.input.ask("введите имя заявки для редактирования : ");
        String nextName = this.input.ask("Обновите имя заявки : ");
        String nextDesc = this.input.ask("Обновите desc : ");
        Item item = new Item(nextName, nextDesc);
        this.tracker.add(item);
        Item[] items = this.tracker.findByName(name);
        int number = 1;
        for (Item element : items) {
            System.out.print(number + ". name --- " + element.getName() + " ---; (ID " + element.getId() + "); desc --- " + element.getDesc());
            number++;
            this.tracker.replace(element.getId(), item);
            System.out.println("/ обновление заявки: name --- " + item.getName() + "; new desc --- " + item.getDesc());
        }
        if (items.length == 0) {
            System.out.println("ххх ничего не найдено! ххх");
        }
    }

    /**
     * Удалить заявку.
     */
    private void delete() {
        System.out.println("---Удаление заявок с именем---");
        String name = this.input.ask("введите имя заявки : ");
        Item[] result = tracker.findByName(name);
        int number = 1;
        for (Item element : result) {
            this.tracker.delete(element.getId());
            System.out.println(number + ". удалена заявка ---> name " + element.getName() + "; ID " + element.getId());
            number++;
        }
    }

    /**
     * Найти по имени.
     */
    private void findByName() {
        System.out.println("--- Найдем заявки по имени ---");
        String name = this.input.ask("введите имя заявки : ");
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

    /**
     * Найти по ID.
     */
    private void findByID() {
        System.out.println("--- Найдем заявку по ID заявки ---");
        String id = this.input.ask("введите ID заявки : ");
        Item result = tracker.findById(id);
        int number = 1;
        if (result != null) {
            System.out.println(number + ". заявка с таким ID --- " + result.getName() + " ---");
        } else {
            System.out.println("ххх ничего не найдено! ххх");
        }
    }

    /**
     * Показывает пункты меню.
     */
    private void showMenu() {
        String text =
                "        Menu\n " +
                        "     0. Add new Item\n" +
                        "     1. Show all items\n" +
                        "     2. Edit item\n" +
                        "     3. Delete item\n" +
                        "     4. Find item by Id\n" +
                        "     5. Find items by name\n" +
                        "     6. Exit Program\n";
        System.out.println(text);
    }
}

