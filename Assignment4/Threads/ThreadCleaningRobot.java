package Threads;

import ReceiverDevices.CleaningRobot;

public class ThreadCleaningRobot implements Runnable {
    private long timer;
    private CleaningRobot cleaningRobot;
    private boolean run;


    public ThreadCleaningRobot(long timeInMillis, CleaningRobot cleaningRobot){
        this.timer = timeInMillis;
        this.cleaningRobot = cleaningRobot;
        this.run = true;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while(run){
            try {
                if(System.currentTimeMillis() - startTime >= timer){
                    cleaningRobot.setRemainingCleaning(-1);
                    cleaningRobot.startCharging();
                    break;
                }
                if(cleaningRobot.batteryStatusWithReturn() <= 0.001){
                    long timeNow = System.currentTimeMillis();
                    long remaining = timer - (timeNow - startTime);
                    cleaningRobot.setRemainingCleaning(remaining);
                    cleaningRobot.startCharging();
                    break;
                }
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop(){
        this.run = false;
    }

}
