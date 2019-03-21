package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String quastion) {
        System.out.print(quastion);
        return scanner.nextLine();
    }

}
