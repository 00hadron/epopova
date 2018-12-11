package ru.job4j.start;

import java.util.List;

/**
 * Класс StubInput для автоматизации пользовательских ответов.
 * @author epopova
 */
public class StubInput implements Input {
    private String[] answers;
    private  int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * @param question вопрос пользователю.
     * @return заданная последовательность ответов пользователя.
     */
    @Override
    public String ask(String question) {
        return this.answers[this.position++];
    }


    @Override
    public int ask(String question, List<Integer> range) {
        Integer key = Integer.valueOf(this.ask(question));
        boolean flag = false;
        for (Integer value : range) {
            if (value.equals(key)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new UnsupportedOperationException("no support operation!");
        }
        return key;
    }
}

