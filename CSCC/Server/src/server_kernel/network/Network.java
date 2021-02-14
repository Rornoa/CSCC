package server_kernel.network;

import input_output.Message1;
import input_output.Message2;
import server_kernel.Invoker;

import java.io.*;
import java.net.*;

public class Network {

    private Socket clientSocket;
    private static ObjectOutputStream oos;
    private static ObjectInputStream ois;
    private Invoker invoker;

    public Network(Invoker invoker){
        this.invoker=invoker;
        try(ServerSocket serverSocket = new ServerSocket(8888)){
            clientSocket = serverSocket.accept();
            ois = new ObjectInputStream(clientSocket.getInputStream());
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
        }catch(IOException e){
            System.out.println("В конструкторе из класса ClientHandler было отловлено IOException");
        }
    }

    public Object read() throws IOException, ClassNotFoundException {
        System.out.println("read() - успешно");
        return ois.readObject();
    }

    public void write(Object object) throws IOException{
        try {
            oos.writeObject(object);
            System.out.println("write() - уcпешно");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void closeStreams() throws IOException {
        ois.close();
        oos.close();
        System.out.println("Потоки чтения и записи обьекта были закрыты!");
    }

    public void closeSocket() throws IOException {
        clientSocket.close();
        System.out.println("Сокет был закрыт.");
    }
}