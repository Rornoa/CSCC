package xml;

import java.util.Scanner;

public class ConsoleReader {

    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    private Scanner scanner;
    private String defaultConsoleSymbol = ">> ";

    public void getDefaultConsoleSymbol() {
        System.out.print(defaultConsoleSymbol);
    }

    public void setDefaultConsoleSymbol(String defaultConsoleSymbol) {
        this.defaultConsoleSymbol = defaultConsoleSymbol;
    }

    public void setInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }

}
