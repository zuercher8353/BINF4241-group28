package Threads;

import ReceiverDevices.Microwave;

class MicrowaveThread implements Runnable {
    private long bakingTime;
    Microwave microwave;

    public MicrowaveThread(long bakingTime, Microwave microwave) {
        this.bakingTime = bakingTime;
        this.microwave = microwave;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1);
            microwave.setEnded();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

