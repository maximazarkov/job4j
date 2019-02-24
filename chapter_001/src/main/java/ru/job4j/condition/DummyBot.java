package ru.job4j.condition;

/**
 * DummyBot - глупый бот
 * @author Maxim Azarkov aza-maxim@yandex.ru
 * @version $Id$
 * @since 0.1 (24.02.2019)
 */
public class DummyBot {

    /**
     * Отвечает на вопросы
     * @param question вопрос от клиента
     * @return Ответ
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Задайте другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) { // заменить ... на проверку, известен ли боту этот вопрос и он знает как на него ответить.
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
