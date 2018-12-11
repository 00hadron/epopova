package ru.job4j.start;

import java.util.List;

/**
 * abstract decorator class InputDecorator implementing the Input interface.
 * @author epopova
 */
public abstract class InputDecorator implements Input {
    protected Input decoratedInput;

    public InputDecorator(Input decoratedInput) {
        this.decoratedInput = decoratedInput;
    }

    public String ask(String question) {
        return this.decoratedInput.ask(question);
    }

    public int ask(String question, List<Integer> range) {
        return this.decoratedInput.ask(question, range);
    }
}

