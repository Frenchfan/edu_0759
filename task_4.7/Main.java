/*
Реализуй в классе Fox интерфейс Animal.
Поменяй код так, чтобы в классе Fox был только один метод - getName.
Учти, что создавать дополнительные классы и удалять методы нельзя!

Требования:
•	Интерфейс Animal должен быть реализован в классе Fox.
•	В интерфейсе Animal нужно объявить метод getColor.
•	Дополнительные классы или интерфейсы создавать нельзя.
*/

public class Main {
    public static void main(String[] args){
        /*Fox Lily = new Fox();
        System.out.println(Lily.getName()+"  "+Lily.getColor()); */
    }
}

interface Animal {
    public String getColor();
}
    
class Fox implements Animal{
    public String getName() {
        return "Fox";
    }
    @Override
    public String getColor(){
        return "Test";
    };
}
