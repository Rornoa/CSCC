package client_kernel;

import client_kernel.network.ClientNetwork;
import input_output.ConsoleReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ClientNetwork client = new ClientNetwork("127.0.0.1",66666);
        ConsoleReader consoleReader = new ConsoleReader();
        Application app = new Application();

        client.write(app.validate(consoleReader.getScanner()));
        client.read();
        client.closeStreams();

    }
}
