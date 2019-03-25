package ru.job4j.pseudo;

/**
 * Класс формирует поведение объекта, расширяя метод drow() интерфеса Paint. Выводится треугольник в виде псевдографики.
 */
public class Triangle implements Shape {

    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("    +    ");
        sb.append(System.lineSeparator());
        sb.append("   / \\   ");
        sb.append(System.lineSeparator());
        sb.append("  /   \\  ");
        sb.append(System.lineSeparator());
        sb.append(" /     \\ ");
        sb.append(System.lineSeparator());
        sb.append("+-------+");
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
//System.getProperty("line.separator")