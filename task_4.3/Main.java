/*
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса,
 возраста и силы.
Нужно сравнить каждый критерий по отдельности,
и победителем будет тот, у которого больше "победивших" критериев.
Метод должен определять, выиграли ли мы (this)
бой или нет, т.е. возвращать true, если выиграли и false - если нет.
Если ничья и никто не выиграл, возвращаем либо true
либо false, по вашему усмотрению
Требования:
•	Класс Cat должен содержать конструктор без параметров.
•	Класс Cat должен содержать всего три поля: age, weight и strength.
Поля должны быть публичные.
•	В классе Cat должен быть метод fight.
•	В методе fight реализовать механизм драки котов
 в зависимости от их веса, возраста и силы согласно условию.
•	Метод должен возвращать одно и тоже значение,
 если мы деремся с одним и тем же котом.
•	Если некий кот1 выигрывает у кота кот2,
то кот2 должен проигрывать коту кот1.
*/

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.age = 3;
        cat1.strength = 5;
        cat1.weight  = 2;

        Cat cat2 = new Cat();
        cat2.age = 5;
        cat2.strength = 6;
        cat2.weight  = 3;
        System.out.println("Правда ли, что победил кот1: "+cat1.fight(cat2));


    }
}

class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int thiscat=0, othercat=0;
        if (this.age > anotherCat.age) thiscat=thiscat+1;
        else if (this.age==anotherCat.age) {
            thiscat=thiscat+1;
            othercat=othercat+1;
        }
        else othercat=othercat+1;
        if (this.weight > anotherCat.weight) thiscat=thiscat+1;
        else if (this.weight== anotherCat.weight) {
            thiscat=thiscat+1;
            othercat=othercat+1;
        }
        else othercat=othercat+1;

        if (this.strength > anotherCat.strength) thiscat=thiscat+1;
        else if (this.strength== anotherCat.strength) {
            thiscat=thiscat+1;
            othercat=othercat+1;
        }
        else othercat=othercat+1;

        if (thiscat>=othercat) return true;
        else return false;
    }
}
