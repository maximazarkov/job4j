package ru.job4j.array;

/**
 * Check.
 * @author Azarkov Maxim.
 * @version $Id$.
 * @since 0.1.
 */
/*
*3. Метод должен проверить, что все элементы в массиве являются true или false.
Например.
{true, true, true} - вернет true;
{true, false, true} - вернет false;
{false, false, false} - вернет true;
*/
public class Check {

    /**
     * mono - check all false or all true in array
     * @param data - array
     * @return boolean true if all true or false else false
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