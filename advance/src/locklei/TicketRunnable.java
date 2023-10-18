package locklei;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketRunnable implements Runnable{
    int ticket = 100;
    Lock l = new ReentrantLock();
    @Override
    public void run() {
            while (true) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                l.lock();
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + "正在卖出第" + ticket + "张票");
                    ticket--;
                }else {
                    break;
                }

                l.unlock();

            }
    }
}

