  
/* 
1. Ввести путь к файлу с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/
import java.util.*;
import java.util.TreeSet;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите полный путь к файлу (либо просто имя файла " +
                "с расширением,если он в текущей папке");
        String filetoopen = scanner.nextLine();
        TreeSet<Integer> sortedcol = new TreeSet<>();
        try (
                //FileInputStream inStream = new FileInputStream("test.txt")
                FileInputStream inStream = new FileInputStream(filetoopen)
        ) {
            scanner = new Scanner(inStream);

            while (scanner.hasNext()) {
                int data = scanner.nextInt();
                if (data % 2 == 0) sortedcol.add(data);
            }
            for (int i : sortedcol) {
                System.out.println(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}