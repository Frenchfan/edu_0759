package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Locale;

public class Server {
    public static void main(String[] args) {
        ArrayList<Socket> clinetSokets = new ArrayList<>();

        ArrayList<String> clientnames = new ArrayList<String>();
        try {
            ServerSocket serverSocket = new ServerSocket(8188); // Создаём серверный сокет
            System.out.println("Сервер запущен");
            while (true){ // бесконечный цикл для ожидания подключения клиентов

                System.out.println("Ожидаю подключения клиентов...");
                Socket socket = serverSocket.accept(); // Ожидаем подключения клиента
                clinetSokets.add(socket);
                System.out.println("Клиент подключился");
                DataInputStream in = new DataInputStream(socket.getInputStream()); // Поток ввода
                DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // Поток вывода

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String request = null;
                            try {out.writeUTF("Введите Ваше имя: ");
                                clientnames.add(clinetSokets.indexOf(socket),"");
                                while (clientnames.get(clinetSokets.indexOf(socket))==""){
                                String clientname = null;
                                clientname = in.readUTF();
                                clientnames.add(clinetSokets.indexOf(socket),clientname);
                                out.writeUTF("Добро пожаловать в чат, "+clientname+". Можете написать Ваше " +
                                            "сообщение:");
                                }
                            }catch (IOException ex){
                                ex.printStackTrace();
                                }
                        while (true){
                            try{
                                request = in.readUTF(); // Принимает сообщение от клиента
                                System.out.println(clientnames.get(clinetSokets.indexOf(socket))+" прислал: "+request);
                                for (Socket clinetSoket: clinetSokets) { // Перебираем клиентов
                                    // которые подключенны в настоящий момент
                                    DataOutputStream out = new DataOutputStream(clinetSoket.getOutputStream());
                                    if (!socket.equals(clinetSoket)) {
                                    out.writeUTF(clientnames.get(clinetSokets.indexOf(socket))+" прислал: " + request); // Рассылает
                                    // принятое сообщение всем клиентам, кроме отправителя
                                    }
                                }
                            }catch (IOException ex){
                                ex.printStackTrace();
                                clinetSokets.remove(socket);// Удаление сокета,
                                // когда клиент отключился
                                clientnames.remove(clinetSokets.indexOf(socket));
                                break;
                            }
                        }
                    }
                });
                thread.start();
            }





        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
