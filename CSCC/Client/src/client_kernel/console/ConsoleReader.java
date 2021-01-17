package client_kernel.console;

import java.util.Scanner;

public class ConsoleReader {

    private Scanner scanner;
    private String defaultConsoleSymbol = ">>";

    public ConsoleReader(){
        scanner = new Scanner(System.in);
    }

    public void printDefaultConsoleSymbol() {
        System.out.print(defaultConsoleSymbol);
    }

    public void setDefaultConsoleSymbol(String defaultConsoleSymbol) {
        this.defaultConsoleSymbol = defaultConsoleSymbol;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setInput(Scanner scanner){
        this.scanner = scanner;
    }


}
