package server_kernel.network;

import input_output.Message;

import java.io.*;
import java.net.*;

public class Network implements Runnable{

    private Socket clientSocket;
    private static ObjectOutputStream oos;
    private static ObjectInputStream ois;


    public Network(){
        try(ServerSocket serverSocket = new ServerSocket(8888)){
            clientSocket = serverSocket.accept();
            ois = new ObjectInputStream(clientSocket.getInputStream());
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
        }catch(IOException e){
            System.out.println("!");
        }
    }

    public Message read() throws IOException, ClassNotFoundException {
        System.out.println("Сервер получил сообщение от клиента.");
        return (Message)ois.readObject();
    }

    public void write(Message object) throws IOException{
        oos.writeObject(object);
        System.out.println("Объект юыл отправлен на клиент.");
    }

    public void closeStreams() throws IOException {
        ois.close();
        oos.close();
        System.out.println("Потоки чтения и записи обьекта были закрыты!");
    }

    public void closeSocket(Socket soc) throws IOException {
        soc.close();
        System.out.println("Сокет был закрыт.");
    }

    @Override
    public void run() {



    }
}