package ru.job4j.coffeeMachine;

/**
 * экзаменационная задача "кофемащина":
 * @author Azarkov Maxim
 * @version 1.1
 */
public class Change {

    int[] coins;

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
        if (price > value)
            throw new NegativeArraySizeException("Недостаточно денежных средств");
        int change = value - price;
        // т.к. по умоляанию значения в "кассете" с монетами все монеты расположены по убыванию
        int count = 0;
        Integer[] countCoins = new Integer[CoinCombinations.coinCombinations.length];
        for (int i = 0; i < CoinCombinations.coinCombinations.length; i++) {
            int coinValueCount = change / CoinCombinations.coinCombinations[i];
            change -= coinValueCount * CoinCombinations.coinCombinations[i];
            countCoins[i] = coinValueCount;
            count += coinValueCount;
        }
        coins = new int[count];

        count = 0;
        for (int i = 0; i < CoinCombinations.coinCombinations.length; i++) {
            addCoin(count, countCoins[i], CoinCombinations.coinCombinations[i]);
            count += countCoins[i];
        }
        return coins;
    }

    private void addCoin (int count, int Nx, int coinValue){
        for (int i = count; i < count + Nx; i++) {
            coins[i] = coinValue;
        }

    }

    /**
     * сласс представляет собой "магазин" монет, который можно загружать в банкомат
     * один из вариантов. Выполнен в виде внутреннего класса (пока так мне показалось удобнее)
     * @since 1.1 - аналог кассеты.
     */
    static class CoinCombinations {
        /**
         * в данной версии "кассета" представленна упорядоченным массиывом по убыванию
         * при изменении веса или количества монет необходимо новые значения расположить по убыванию
         */
        private static int[] coinCombinations = {10, 5, 2, 1};

        /*
         * прототип метода, принимающий неотсортированный список монет, для сортировки и сохранении
         * его в coinsCombinations.
         * при реализации можно данный метод переделать в TreeSet
         * @deprecated  - в данной версии не реализован. т.к. нет необходимости
         */
        //public createCoinsMagazine(int[] coinsValue) {
        // принять данные, отсортировать, разместить в coinsCombinations
        // }
    }
}
