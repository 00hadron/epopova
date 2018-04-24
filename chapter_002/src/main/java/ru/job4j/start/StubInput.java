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
}

