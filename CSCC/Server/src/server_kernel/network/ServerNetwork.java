package server_kernel.network;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerNetwork extends Thread
{
    // открываемый порт сервера
    private static final int port   = 6666;
    private String TEMPL_MSG =
            "Clietn №%d: ";
    private String TEMPL_CONN =
            "The client '%d' closed the connection.";

    private  Socket socket;
    private  int    num;

    public ServerNetwork() {
        try(){
            ServerSocket = serverSocket

        }


    }



    public void setSocket(int num, Socket socket)
    {
        // Определение значений
        this.num    = num;
        this.socket = socket;

        // Установка daemon-потока
        setDaemon(true);
        /*
         * Определение стандартного приоритета главного потока
         * int java.lang.Thread.NORM_PRIORITY = 5-the default
         *               priority that is assigned to a thread.
         */
        setPriority(NORM_PRIORITY);
        // Старт потока
        start();
    }
    public void run()
    {
        try {
            // Определяем входной и выходной потоки сокета
            // для обмена данными с клиентом

            InputStream  sin  = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream  dis = new DataInputStream (sin );
            DataOutputStream dos = new DataOutputStream(sout);

            InputStreamReader isr;
            isr = new InputStreamReader(System.in);
            BufferedReader keyboard;
            keyboard = new BufferedReader(isr);

            String serverSays = null;
            String line = null;
            while(true) {
                // Ожидание сообщения от клиента
                line = dis.readUTF();
                System.out.println(String.format(TEMPL_MSG, num) + line);
                // Отсылаем клиенту обратно эту самую
                // строку текста
                serverSays = keyboard.readLine();
                System.out.println("Server: "+serverSays);
                dos.writeUTF("Server: " + serverSays);
                // Завершаем передачу данных
                dos.flush();
                System.out.println();
                if (line.equalsIgnoreCase("quit")) {
                    // завершаем соединение
                    socket.close();
                    System.out.println(
                            String.format(TEMPL_CONN, num));
                    break;
                }
            }
        } catch(Exception e) {
            System.out.println("Exception : " + e);
        }
    }
    //---------------------------------------------------------
    public static void main(String[] ar)
    {
        ServerSocket srvSocket = null;
        try {
            try {
                int i = 0; // Счётчик подключений
                // Подключение сокета к localhost
                InetAddress ia;
                ia = InetAddress.getByName("localhost");
                srvSocket = new ServerSocket(port, 0, ia);

                System.out.println("Server started\n\n");

                while(true) {
                    // ожидание подключения
                    Socket socket = srvSocket.accept();
                    System.err.println("Client accepted");
                    // Стартуем обработку клиента
                    // в отдельном потоке
                    new ServerNetwork().setSocket(i++, socket);
                }
            } catch(Exception e) {
                System.out.println("Exception : " + e);
            }
        } finally {
            try {
                if (srvSocket != null)
                    srvSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }
}