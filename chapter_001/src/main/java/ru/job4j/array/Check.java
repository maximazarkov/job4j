package ru.job4j.array;

/**
 * Check.
 * @author Azarkov Maxim.
 * @version $Id$.
 * @since 0.1.
 */
public class Check {

    /**
     * mono - проверка всех false или всех true в массиве.
     * @param data - array.
     * @return возвращает true, если все значения  true или false иначе возвращается false.
     * <p>
     * 3. Метод проверяет, что все элементы в массиве являются true или false.
     * Например:
     * {true, true, true} - вернет true;
     * {true, false, true} - вернет false;
     * {false, false, false} - вернет true;
     * </p>
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            //if (data[i] == data[i + 1]) { этот случай нас не интересует
            //if (data[i] != data[i + 1]) { и тогда резулт фолс и брейк
            //и изначально считайте что все элементы одинаковые
            if (data[i] != data[i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}