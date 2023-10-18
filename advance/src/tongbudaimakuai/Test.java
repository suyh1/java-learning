public class Test {
    public static void main(String[] args) throws Exception{
        TicketRunnable t = new TicketRunnable();

        new Thread(t, "窗口1").start();
        new Thread(t, "窗口2").start();
        new Thread(t, "窗口3").start();
        new Thread(t, "窗口4").start();

    }
}
