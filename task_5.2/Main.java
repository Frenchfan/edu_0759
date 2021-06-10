/*
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи
Лондон
Пример вывода:
Абрамовичи */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Модернизация ПО
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (true) {
            if (list.size()%2!=0) {
                System.out.println("Введите фамилию. Для завершения - нажмите enter");
                String family = scanner.nextLine();
                if (family.isEmpty()) {
                    break;
                }
                list.add(family);
            }
            else {
                System.out.println("Введите город. Для завершения - нажмите enter");
                String family = scanner.nextLine();
                if (family.isEmpty()) {
                    break;
                }
                list.add(family);
            }
        }

        // Read the city
        System.out.println("Введите город для отображения семьи, которая там проживает");
        String city = scanner.nextLine();

        if (!city.equals(""))         {
            String familyName = list.get(list.indexOf(city)+1);
            System.out.println(familyName);
        }
    }
}
