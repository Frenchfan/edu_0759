/*
Пользователь вводит число, необходимо увеличить это число на 15% и вывести результат на экран
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите число");
        Scanner scan = new Scanner(System.in);
        double digit = scan.nextFloat();
        digit=digit+digit*0.15;
        System.out.println("Если увеличить Ваше число на 15%, получится "+digit);
    }
}
