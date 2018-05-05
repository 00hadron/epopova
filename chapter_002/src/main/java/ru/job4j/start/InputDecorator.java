package ru.job4j.start;

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

    public int ask(String question, int[] range) {
        return this.decoratedInput.ask(question, range);
    }
}

