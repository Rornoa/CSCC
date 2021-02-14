import server_kernel.Application;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
    Application app = new Application();
    app.initializeCommands();
    app.startServer();
    }
}