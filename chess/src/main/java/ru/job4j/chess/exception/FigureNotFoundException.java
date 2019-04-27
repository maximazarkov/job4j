package ru.job4j.chess.exception;

public class FigureNotFoundException extends RuntimeException {
    private FigureNotFoundException() {}
    public FigureNotFoundException(String msg) { super(msg); }
}
