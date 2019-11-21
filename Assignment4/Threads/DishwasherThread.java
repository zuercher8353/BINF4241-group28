package Threads;

import ReceiverDevices.*;

public class DishwasherThread implements Runnable{
    private long washingTime;
    private Dishwasher dishwasher;
    private boolean run;

    public DishwasherThread(long washingTime, Dishwasher dishwasher) {
        this.washingTime = washingTime;
        this.dishwasher = dishwasher;
        this.run = true;
    }

    public void run() {
        while (run) {
            try {
                Thread.sleep(washingTime);
                dishwasher.setEnded();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop(){
        this.run = false;
    }
}
