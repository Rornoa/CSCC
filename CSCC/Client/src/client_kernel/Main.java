package client_kernel;

import client_kernel.network.Network;
import input_output.ConsoleReader;
import input_output.Message1;
import input_output.Message2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Network client = new Network("localhost",8888);
        ConsoleReader consoleReader = new ConsoleReader();
        do {
            Validator app = new Validator();

            Message1 message1 = app.validate(consoleReader.getScanner());
            if (message1.getCommandName() != null) {
                client.write(message1);
                Message2 message2 = (Message2) client.read();
                System.out.println(message2.getStringMessageToClient());
            }else
            client.closeStreams();
        }while(true);
    }
}
