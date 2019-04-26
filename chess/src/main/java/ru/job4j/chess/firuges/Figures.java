package ru.job4j.chess.firuges;

public abstract class Figures {
    // данные поля и методы повторяются во всех фигурах и имеют общую сигнатуру,
    // по этой причине мы их вынесли в отдельный общий абстрактный метод
    // есть мысль организовать абстрактную фабрику, но это уже рефакторинг на будущее
    private final Cell position;

    public Figures(final Cell position) {
        this.position = position;
    }

    public Cell position() {
        return this.position;
    }


}
