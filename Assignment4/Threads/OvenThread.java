package Threads;

import ReceiverDevices.*;

public class OvenThread implements Runnable {
    private long bakingTime;
    Oven oven;
    private boolean run;

    public OvenThread (long bakingTime, Oven oven){
        this.bakingTime = bakingTime;
        this.oven = oven;
        this.run = true;
    }


    @Override
    public void run() {
        while (run) {
            try {
                Thread.sleep(bakingTime);
                oven.setEnded();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop(){
        this.run = false;
    }

}
