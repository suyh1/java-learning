public class Test {
    public static void main(String[] args) throws Exception{
        Thread t = Thread.currentThread();
        System.out.println(t.getName());
        Thread.sleep(3000);
    }
}
