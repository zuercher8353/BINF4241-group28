package Threads;

import ReceiverDevices.*;

public class DishwasherThread implements Runnable{
    private long washingTime;
    private Dishwasher dishwasher;

    public DishwasherThread(long washingTime, Dishwasher dishwasher) {
        this.washingTime = washingTime;
        this.dishwasher = dishwasher;
    }

    public void run() {
        try {
            Thread.sleep(1);
            dishwasher.setEnded();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
