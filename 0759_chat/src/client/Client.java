package client;

import server.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket ("127.0.0.1", 8188 );
            System.out.println("Успешно подключен");
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            String request = scanner.nextLine();
            out.writeUTF(request);
            String response = null;
            while (true) {
                response = in.readUTF();
                System.out.println("");
            }
            System.out.println("");


        }
    }
}
