package com.example.javalabs.javaclientserverrandomarray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ExampleClient {
    public static void main(String[] args) throws Exception {
        try {
            Socket mySocket = new Socket("127.0.0.1",7890);
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            ObjectOutputStream outp = new ObjectOutputStream(mySocket.getOutputStream());
            ObjectInputStream  inp = new ObjectInputStream(mySocket.getInputStream());
            String clientMessage;
            do {
                System.out.println("Введи матрицу в формате \nХ Х X Х Х Х Х Х Х\n\t('q' − вызод из программы)");
                clientMessage = stdin.readLine();
                if (clientMessage.matches("-?[0-9]+\\.?[0-9]* -?[0-9]+\\.?[0-9]* -?[0-9]+\\.?[0-9]* -?[0-9]+\\.?[0-9]* -?[0-9]+\\.?[0-9]* -?[0-9]+\\.?[0-9]* -?[0-9]+\\.?[0-9]* -?[0-9]+\\.?[0-9]* -?[0-9]+\\.?[0-9]*"))
                {
                    System.out.println("Введено: "+clientMessage);
                    outp.writeObject(clientMessage);
                    System.out.println("~server~: "+inp.readObject());
                    System.out.println("---------------------------");
                }
                else System.out.println("Неверный ввод");
            }while(!(clientMessage.charAt(0) == 'q'));
            outp.close();
            inp.close();
            mySocket.close();
        }catch(Exception ex)	{
            ex.printStackTrace();
        }
    }
}
