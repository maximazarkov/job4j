package ru.job4j.chess.exception;

public class OccupiedWayException extends RuntimeException {
    private OccupiedWayException() { }
    public  OccupiedWayException(String msg) {
        super(msg);
    }
}
