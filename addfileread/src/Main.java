import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try {
            //Запись побайтная. Поток закрывается автоматически!
            FileOutputStream fos = new FileOutputStream("D://Java//test.txt", true);
            String text = "Hello, world!"; // для дополнительной записи выставляем
            // доп параметр append - см. строка выше
            //String text = "123123"; - перезапись файла целиком
            byte[] buffer = text.getBytes();
            fos.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //чтение побайтное. Поток закрывается автоматически!
            FileInputStream fis = new FileInputStream("D://Java//test.txt");
            int i;
            //int i=fis.read();//возвращает 72 - это H в таблице ASCII, поскольку чтение. В конце строки - 13
            // (возврат каретки) ,а потом 10. То есть можно построчно читать.
            // происходит посимвольное - http://900igr.net/up/datas/120393/013.jpg
            while ((i=fis.read())!=-1) {//цикл нужен, чтобы читать до конца файла!
                System.out.print((char) i);// кастуем числовую переменную в символ
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

