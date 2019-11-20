package Threads;

import ReceiverDevices.*;

public class OvenThread implements Runnable {
    private long bakingTime;
    Oven oven;

    public OvenThread (long bakingTime, Oven oven){
        this.bakingTime = bakingTime;
        this.oven = oven;
    }


    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while(true){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
