package Threads;

import ReceiverDevices.CleaningRobot;

public class ThreadCleaningRobot implements Runnable {
    private long timer;
    CleaningRobot cleaningRobot;

    public ThreadCleaningRobot(long timeInMillis, CleaningRobot cleaningRobot){
        this.timer = timeInMillis;
        this.cleaningRobot = cleaningRobot;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while(true){
            try {
                if(System.currentTimeMillis() - startTime >= timer){
                    cleaningRobot.setRemainingCleaning(-1);
                    cleaningRobot.startCharging();
                    break;
                }
                if(cleaningRobot.batteryStatusWithReturn() < 5){
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
}
