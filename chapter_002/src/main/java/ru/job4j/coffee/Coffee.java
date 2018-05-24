package ru.job4j.coffee;

/**
 * Сдача с продажи кофе минимальным числом банкнот.
 * @author epopova
 * @since 24.05.2018
 */
public class Coffee {
    private int value;
    private int price;
    private int back;
    private int[] nominals;
    private int[] temp;
    int position;
    private boolean flag;

    /**
     * Дефолтный конструктор.
     */
    public Coffee() {
        this.nominals = new int[]{500, 200, 100, 50, 10, 5, 2, 1};
        this.flag = false;
        this.temp = new int[30];
        this.position = 0;
    }

    /**
     * setter для входной банкноты.
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * setter для цены.
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Meтод возвращает массив банкнот для сдачи.
     * Количество банкном минимальное.
     * Жадный перебор.
     * Найти длину результирующего массива и заполнить его.
     * @return массив банктнот для сдачи.
     */
    public int[] changes() {
        this.back = this.value - this.price;
        int tmp = this.back;
        this.checkup();
        int length = 0;
        for (int index = 0; index != nominals.length; index++) {
            int nominal = nominals[index];
            int quantity = tmp / nominal;
            length = length + quantity;
            tmp = tmp - quantity * nominal;
            add(quantity, nominal);
            if (tmp == 0) {
                break;
            }
        }
        int[] result = new int[length];
        System.arraycopy(temp, 0, result, 0 , result.length);
        return result;

    }

    /**
     * Заполняет часть временного массиа фиксированной длинны банктнотами.
     * @param quantity штук банктнот такого номинала
     * @param nominal номинал
     */
    private  void add(int quantity, int nominal) {
        for (int index = position; index !=  temp.length; index++) {
            if (quantity == 0) {
                break;
            }
            temp[index] = nominal;
            position++;
            quantity--;
        }
    }

    /**
     * Проверяет исключительные ситуации.
     */
    private void checkup() {
        for (int bond : nominals) {
            if (this.value == bond) {
                this.flag = true;
                break;
            }
        }
        if (!this.flag) {
            throw new UnsupportedOperationException("Такие купюры не существуют!");
        }

        if (this.back < 0) {
            throw new UnsupportedOperationException("Недостаточно введенных денег!");
        }
    }
}
