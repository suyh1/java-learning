package tongbudaimakuai;

public class TicketRunnable implements Runnable{
    int ticket = 100;
    @Override
    public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                sellTicket();

            }
    }

    public synchronized void sellTicket() {
        if(ticket > 0){
             System.out.println(Thread.currentThread().getName() + "正在卖出第" + ticket + "张票");
             ticket--;
        }
    }
}
