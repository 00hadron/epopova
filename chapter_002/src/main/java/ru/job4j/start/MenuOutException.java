package ru.job4j.start;

/**
 *  Класс MemuOutExeption принимает сообщение об ошибке в конструктор и передает его в конструктор родителя.
 *  @author epopova
 */
public class MenuOutException extends RuntimeException {
    public  MenuOutException(String msg) {
        super(msg);
    }
}
