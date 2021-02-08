package server_kernel;

import server_kernel.network.ClientHandler;

public class Main {

    ClientHandler clientHandler;

    public static void main(String[] args) {
    ApplicationManager app = new ApplicationManager();
    app.initialize();
    app.serverStarter();


    }
}