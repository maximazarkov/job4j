package ru.job4j.coffeeMachine;

/**
 * экзаменационная задача "кофемащина":
 * @author Azarkov Maxim
 * @version 1.0
 */
public class Change {

    /**
     * Метод выдачи сдачи для автомата.
     * Пример. Мы засунули 50 рублей выбрали кофе за 35. Сдачу автомат выдаст 15 рублей
     * Алгоритм возвращает наименьшее количество монет.
     * Метод вернет массив {10, 5} = 15 рублей
     * в автомате монеты наминалом 1 2 5 10
     *
     * @param price - цена
     * @param value - купюра. 50 100 и тд.
     * @return - Метод вернет массив {10, 5} 15 рублей
     * @since 1.0
     */
    public int[] change(int price, int value) {
        int change = value - price;
        int N10 = change / 10;
        change -= N10 * 10;
        int N5 = change / 5;
        change -= N5 * 5;
        int N2 = change / 2;
        change -= N2 * 2;
        int N1 = change;
        int[] result = new int[N10 + N5 + N2 + N1];
        addCoin(0, N10, 10, result);
        addCoin(N10, N5, 5, result);
        addCoin(N10 + N5, N2, 2,  result);
        addCoin(N10 + N5 + N2, N1, 1, result);
        return result;
    }

    private void addCoin (int count, int Nx, int coinValue, int[] result) {
        for (int i = count; i < count + Nx; i++) {
            result[i] = coinValue;
        }

    }
}
