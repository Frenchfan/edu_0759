/*
* Задание: Дана коллекция с числами. Запишите в новую коллекцию только те числа,
* которые больше нуля и меньше 10-ти.
* Коллекции вы создаёте сами
*/

import java.lang.reflect.Array;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> samplecol = new ArrayList();
        samplecol.add(-5);
        samplecol.add(2);
        samplecol.add(15);
        samplecol.add(7);
        samplecol.add(0);
        samplecol.add(3);
        ArrayList<Integer> sortedcol = new ArrayList();
        for (int i = 0; i < samplecol.size(); i++) {
            if (samplecol.get(i) > 0 && samplecol.get(i) < 10) {
                sortedcol.add(samplecol.get(i));
            }
        }
        //Для наглядности покажем все элементы новой отсортированной коллекции
        for (int i = 0; i < sortedcol.size(); i++) {
            System.out.println(sortedcol.get(i));
        }



    }
}
