package Threads;

import ReceiverDevices.*;

public class MicrowaveThread implements Runnable {
    private long bakingTime;
    private Microwave microwave;
    private boolean run;

    public MicrowaveThread(long bakingTime, Microwave microwave) {
        this.bakingTime = bakingTime;
        this.microwave = microwave;
        this.run = true;
    }

    @Override
    public void run() {
        while (run) {
            try {
                Thread.sleep(bakingTime);
                microwave.setEnded();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop(){
        this.run = false;
    }
}


