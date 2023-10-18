package tongbusuo;

public class Test {
    public static void main(String[] args) {
        new MyThread().start();


        synchronized (MyThread.class) {
            System.out.println("主线程:开门");
            System.out.println("主线程:点火");
            System.out.println("主线程:驾驶");
            System.out.println("主线程:熄火");
            System.out.println("主线程:关门");
        }
    }
}
