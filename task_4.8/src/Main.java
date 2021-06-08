import java.sql.SQLOutput;
import java.util.Scanner;

/*
 *  ***Гостиница***
 *  1) Гостиница
 *  2) Номера (кол-во мест(1-3), сан.узел(есть/нет),
 * питаение(есть/нет), wifi(есть/нет), свободен/занят)
 *
 *   *Задание для лабораторной работы №4*
 *   Освободить комнату
 *   Вывести свойства комнаты
 *   Показать комнаты с WiFi
 *   Показать комнаты с WC
 *   Показать комнаты с Eat
 *   Показать комнаты по кол-ву спальных мест
 *   Отобразить список команд
 * */
public class Main {
    public static void main(String[] args) {
        Room[] rooms = {
                new Room((byte) 1,false,false,true,(byte) 11),
                new Room((byte) 2,true,true,false,(byte) 12),
                new Room((byte) 1,false,true,true,(byte) 13),
                new Room((byte) 3,true,false,false,(byte) 21),
                new Room((byte) 2,false,false,false,(byte) 22),
                new Room((byte) 1,true,true,true,(byte) 23),
                new Room((byte) 3,false,true,false,(byte) 31),
                new Room((byte) 3,true,true,false,(byte) 32),
                new Room((byte) 1,false,false,true,(byte) 33),
        };
        Hotel hotel = new Hotel(rooms);
        Scanner scanner = new Scanner(System.in);
        String command;
        while (true){
            System.out.println("Введите команду");
            command = scanner.nextLine();
            if(command.equals("getFreeRooms")){
                hotel.getFreeRooms();}
            else if(command.equals("getWifiRooms")){
                    hotel.getWifiRooms(); }
            else if(command.equals("getWCRooms")){
                hotel.getWCRooms(); }
            else if(command.equals("getEatRooms")){
                hotel.getEatRooms(); }
            else if(command.equals("sortby")){
                System.out.print("Комнаты на сколько мест интересуют?: ");
                byte quantity = (byte) scanner.nextInt();
                hotel.sortby(quantity);}
            else if(command.equals("reserveRoom")){
                System.out.print("Введите номер комнаты для бронирования: ");
                byte roomNumber = (byte) scanner.nextInt();
                hotel.reserveRoom(roomNumber);
            }else if(command.equals("Roomdescription")){
                System.out.print("Введите номер комнаты для описания: ");
                byte roomNumber = (byte) scanner.nextInt();
                hotel.getRoomdescription(roomNumber);
            }else if(command.equals("freeRoom")){
                System.out.print("Введите номер комнаты, из которой выезжают клиенты: ");
                byte roomNumber = (byte) scanner.nextInt();
                hotel.freeRoom(roomNumber);
            }else if(command.equals("?")){
                System.out.print("В системе предусмотрены следующие команды: ");
                System.out.println("getFreeRooms - список свободных комнаты");
                System.out.println("getWifiRooms - список комнат с WiFi");
                System.out.println("getWCRooms - список комнат с отдельным санузлом");
                System.out.println("getEatRooms - список комнат с включенным завтраком");
                System.out.println("sortby - сортировка комнат по кол-ву постояльцев (1-3)");
                System.out.println("reserveRoom - бронирование комнаты");
                System.out.println("Roomdescription - описание комнаты");
                System.out.println("freeRoom - освободить комнату после выезда постояльцев");
            }else if (command.equals("exit")){
                break;
            }
        }

    }
}
