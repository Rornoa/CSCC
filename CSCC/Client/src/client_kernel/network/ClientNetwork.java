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
    }

    public static ObjectInputStream getOis(){ return ois; }

    public static ObjectOutputStream getOos(){ return oos; }

    public static void openStream(Socket socket)
    {
        try {
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
                                    .getHostAddress() +
                            "\n\tReceiveBufferSize (SO_RCVBUF) = "
                            + socket.getReceiveBufferSize());

            // Получаем входной и выходной потоки
            // сокета для обмена сообщениями с сервером
            ObjectOutputStream out = getOos();
            ObjectInputStream in = getOis();

            // Создаем поток для чтения с клавиатуры.
            InputStreamReader isr;
            isr = new InputStreamReader(System.in);
            BufferedReader keyboard;
            keyboard = new BufferedReader(isr);
            String line = null;
            System.out.println(
                    "Start conversation by pressing enter");
            System.out.println();
            while (true) {
                // Пользователь должен ввести строку
                // и нажать Enter


                line = keyboard.readLine();
                // Отсылаем строку серверу
                System.out.println("Client: "+ line);
                out.writeUTF(line);
                // Завершаем поток
                out.flush();
                // Ждем ответа от сервера
                line = in.readUTF();
                if (line.endsWith("quit"))
                    break;
                else {
                    System.out.println(
                            ""
                                    + line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void write(Object object){ list.add(object); }

    public Object read() throws IOException, ClassNotFoundException {
        return ois.readObject();
    }

    public void closeStreams() throws IOException {
        ois.close();
        oos.close();
        try {
            if (socket != null)
                socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}