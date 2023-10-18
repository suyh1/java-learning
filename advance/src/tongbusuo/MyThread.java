package tongbusuo;

public class MyThread extends Thread{
    @Override
    public void run() {
        drive();
    }

    public synchronized static void drive() {
        System.out.println("子线程:开门");
        System.out.println("子线程:点火");
        System.out.println("子线程:驾驶");
        System.out.println("子线程:熄火");
        System.out.println("子线程:关门");
    }
}
