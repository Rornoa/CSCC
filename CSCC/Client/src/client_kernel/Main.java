package client_kernel;

import input_output.Message;
import java.io.IOException;


public class Main {
    public static void main(String[] args){
        UserRequestValidator  urv;
        System.out.println(" Клиент был запущен. ");

        while(true){
            try{
                urv = new UserRequestValidator();
                Message message = urv.validate();

            }catch(IOException e){
                System.out.println("Ошибичка вышла!");

            }
        }
    }
}
