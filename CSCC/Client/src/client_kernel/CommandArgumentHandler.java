package client_kernel;

import client_kernel.console.ConsoleReader;
import exceptions.IMassages;

import java.util.Scanner;

public class CommandArgumentHandler implements IMassages {

    private Scanner scanner;
    private ConsoleReader consoleReader;

    public CommandArgumentHandler() {
        this.consoleReader = new ConsoleReader();
    }

    public int treatmentInt() {
        while (true){
            System.out.println("Введите значение для команды");
            consoleReader.printDefaultConsoleSymbol();
            try {
                String readLine = consoleReader.getScanner().nextLine().trim();
                if (readLine.length() == 0) {
                    System.out.println(messageOfEmptyFormatError);
                    continue;
                }

                if (readLine.length() > 3) {
                    System.out.println(messageOfInputValueError);
                    continue;
                }

                return Integer.parseInt(readLine);

            } catch(NumberFormatException e){
                System.out.println(messageOfInputFormatError);
            }
        }
    }

    public String treatmentString() {
        while (true) {
            System.out.println("Введите значение для команды");
            consoleReader.printDefaultConsoleSymbol();
            try {
                String readLine = consoleReader.getScanner().nextLine().trim();
                if (readLine.length() == 0) {
                    System.out.println(messageOfEmptyFormatError);
                    continue;
                }

                if (readLine.length() < 3 || readLine.length() > 20) {
                    System.out.println(messageOfInputValueError);
                    continue;
                }

                return readLine;

            } catch (NumberFormatException e) {
                System.out.println(messageOfInputFormatError);
            }
        }
    }
}
