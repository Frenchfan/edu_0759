package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        //192.168.3.28 - уникальный для локальной сети
        // 188.255.89.221 - внешний (2ip.ru)
        //localhost - у всех одинаковый
        try {
            ServerSocket serverSocket = new ServerSocket(8188);//выбрали вот такой порт для прослушивания.
            // возможен exception - занят порт другим приложением - try catch
            System.out.println("Сервер запущен");
            System.out.println("Ожидаю подключение клиентов");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String request = in.readUTF();
            System.out.println("Клиент прислал сообщение: "+request);
            while (true) {
                request = in.readUTF();
                System.out.println("Клиент прислал: "+request);
                out.writeUTF(request.toUpperCase(request));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

