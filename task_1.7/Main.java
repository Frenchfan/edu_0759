/* Задача наполнить корабельный бассейн. Нужно посчитать, сколько литров воды нужно для заполнения бассейна до бортов.
Известно, что бассейн имеет линейные размеры a × b × c, заданные в метрах.
Эти размеры передаются запрашиваются у пользователя. Прграмма должена вывести на экран количество литров воды,
которое нужно для наполнения бассейна.
Пример:
Пользователь даёт числа 25, 5, 2.
Пример вывода:
250000 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите длину в метрах");
        Scanner scan = new Scanner(System.in);
        int width = scan.nextInt();
        System.out.println("Введите ширину в метрах");
        int length = scan.nextInt();
        System.out.println("Введите высоту в метрах");
        int height = scan.nextInt();
        System.out.println("Для заполнения бассейна нужно "+(width*length*height*1000));
    }
}
