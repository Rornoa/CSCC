package client_kernel.network;

import java.io.*;
import java.net.*;

public class ClientNetwork { // TODO: 20.01.2021 Обернуть код в статичные методы
    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try{
            echoSocket = new Socket("taranis", 7);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

        } catch (UnknownHostException e) {
            System.err.println("Don’t know about host: taranis.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn’t get I/O for "+ "the connection to: taranis.");
            System.exit(1);
        }

        String userInput;
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("echo: " + in.readLine());
        }
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }


}
