package input_output;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

public class ConsoleReader {

    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    private Scanner scanner;
    private String defaultConsoleSymbol = ">>";

    public void printDefaultConsoleSymbol() {
        System.out.print(defaultConsoleSymbol);
    }

    public String readFromConsole(){
        System.out.println("Введите название комманды и аргуент через пробел");
        System.out.println(defaultConsoleSymbol);
        String command = scanner.nextLine().trim();
        return command;
    }

    public void setDefaultConsoleSymbol(String defaultConsoleSymbol) { this.defaultConsoleSymbol = defaultConsoleSymbol;}

    public void setInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }

}
