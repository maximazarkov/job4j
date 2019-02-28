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
        boolean result = false;
        int count = 0;
        //IDEA предложила именить код на foreach...
        //for (int i = 0; i < data.length; i++) {
        //    if (data[i]) count++;
        //}
        // вот что получилось
        for (boolean iData:data) {
            // можно воспользоватся тернарным оператором,
            // но думаю, будет не рационально, по этому if...
            if (iData) {
                count++;
            }
        }
        if (count == data.length || count == 0) {
            result = true;
        }
        return result;
    }
}