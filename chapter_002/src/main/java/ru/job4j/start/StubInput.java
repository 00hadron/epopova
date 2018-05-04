package ru.job4j.start;

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
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean flag = false;
        for (int value : range) {
            if (value == key) {
                flag = true;
                break;
            }
        }
        if (flag) {
            return key;
        } else {
            throw new UnsupportedOperationException("no support operation!");
        }
    }
}

