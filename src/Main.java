public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("T1");
        MyThread t2 = new MyThread("T2");
        MyThread t3 = new MyThread("T3");

        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Все процессы окончены!");
    }
}

class MyThread extends Thread {


    public MyThread(String name) {
        super(name);
    }


    @Override
    public void run() {
        System.out.println("(Thread) Выполняется процесс " + getName());
        System.out.print("до завершения осталось: ");
        for (int i = 4; i >= 0; i--) {
            System.out.print(i + ".. ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }
}