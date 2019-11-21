package Threads;

import ReceiverDevices.WashingMachine;

public class WashingMachineThread implements Runnable{
    private long washingTime;
    private WashingMachine washingMachine;
    private boolean run;

    public WashingMachineThread(long washingTime, WashingMachine washingmachine){
        this.washingTime = washingTime;
        this.washingMachine = washingmachine;
        this.run = true;
    }

    @Override
    public void run(){
        while (run) {
            try {
                Thread.sleep(washingTime);
                washingMachine.setEnded();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop(){
        this.run = false;
    }
}
