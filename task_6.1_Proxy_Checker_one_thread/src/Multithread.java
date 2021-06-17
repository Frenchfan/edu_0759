//Мыть посуду = 45 мин
//Стирать белье 60 мин + 10 мин = 70 мин
//Мыть полы = 20 мин
// В Java многопоточность - это как будто у Вас есть копии самого себя
/*public class Multithread {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("Мыть посуду");
        MyThread myThread2 = new MyThread("Стирать белье");
        MyThread myThread3 = new MyThread("Мыть полы");
        myThread1.start();
        myThread2.start();
        myThread3.start();



    }
}*/
class MyRunnable implements Runnable{
    private String task;

    public MyRunnableThread(String task) {
        this.task = task;
    }
}

// Сначала создадим класс, в котором реализуем многпоточность
class MyThread extends Thread {
    private String task;

    public MyThread(String task){
        super();
        this.task=task;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.task+"выполнено: "+i+"%");
        }
    }
}