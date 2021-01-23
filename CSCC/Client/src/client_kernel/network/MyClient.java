package client_kernel.network;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class MyClient
{
    private  static final int    serverPort = 6666;
    private  static final String localhost  = "127.0.0.1";

    public static void main(String[] ar)
    {
        Socket socket = null;
        try{
            try {
                System.out.println("Welcome to Client side\n" +
                        "Connecting to the server\n\t" +
                        "(IP address " + localhost +
                        ", port " + serverPort + ")");
                InetAddress ipAddress;
                ipAddress = InetAddress.getByName(localhost);
                socket = new Socket(ipAddress, serverPort);
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
                InputStream  sin  = socket.getInputStream();
                OutputStream sout = socket.getOutputStream();

                DataInputStream  in ;
                DataOutputStream out;
                in  = new DataInputStream (sin );
                out = new DataOutputStream(sout);

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
        } finally {
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}