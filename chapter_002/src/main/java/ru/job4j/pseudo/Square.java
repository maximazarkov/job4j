package ru.job4j.pseudo;

/**
 * <p>Класс Square формирует поведение объекта, расширяя метод drow() интерфеса Paint. Выводится квадрат в виде псевдографики.
 */
public class Square implements Shape {

    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("+---+");
        sb.append(System.lineSeparator());
        sb.append("|   |");
        sb.append(System.lineSeparator());
        sb.append("|   |");
        sb.append(System.lineSeparator());
        sb.append("|   |");
        sb.append(System.lineSeparator());
        sb.append("+---+");
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
