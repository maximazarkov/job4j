package ru.job4j.chess.exception;

public class ImpossibleMoveException extends RuntimeException {
    private ImpossibleMoveException() { }
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
