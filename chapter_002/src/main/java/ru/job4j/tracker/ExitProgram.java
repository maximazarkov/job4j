package ru.job4j.tracker;

public class ExitProgram extends BaseAction {
    public ExitProgram(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
// ничего не делаем
    }
}
