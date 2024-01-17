package ru.otus.spring.service;

import java.util.Scanner;

public class ReadLineConsole implements ReadLine {
    @Override
    public String getLine(String lineName) {
        System.out.println("Please enter " + lineName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
