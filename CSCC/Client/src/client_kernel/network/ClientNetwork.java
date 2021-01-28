package client_kernel.network;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientNetwork
{
    private transient Socket socket;
    private static transient ObjectOutputStream oos;
    private static transient ObjectInputStream ois;
    private ArrayList list;
    private String address;
    private int port;

    public ClientNetwork(String address, int port) throws IOException {
        this.address = address;
        this.port = port;
        socket = new Socket(address,port);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
        System.out.println("Welcome to Client side\n" +
                "Connecting to the server\n\t" +
                "(IP address " + socket.getInetAddress() +
                ", port " + socket.getPort() + ")");
        System.out.println(
                "The connection is established.");
        System.out.println(
                "\tLocalPort = " +
                        socket.getLocalPort() +
                        "\n\tInetAddress.HostAddress = " +
                        socket.getInetAddress()
                                .getHostAddress());

    }

    public static ObjectInputStream getOis(){ return ois; }

    public static ObjectOutputStream getOos(){ return oos; }

    public void write(Object object) throws IOException {
        while(object!=null){
            oos.writeObject(object);
        }
    }

    public Object read() throws IOException, ClassNotFoundException {
        return ois.readObject();
    }

    public void closeStreams() throws IOException {
        ois.close();

        oos.flush();
        oos.close();
        try {
            if (socket != null)
                socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}