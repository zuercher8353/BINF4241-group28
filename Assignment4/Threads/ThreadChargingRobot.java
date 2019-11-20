package Threads;

import ReceiverDevices.CleaningRobot;

public class ThreadChargingRobot implements Runnable {
    private long timeUntilFullyCharged;
    CleaningRobot cleaningRobot;

    public ThreadChargingRobot(long timeUntilFullyCharged, CleaningRobot cleaningRobot){
        this.timeUntilFullyCharged = timeUntilFullyCharged;
        this.cleaningRobot = cleaningRobot;
    }


    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while(true){
            try {
                if(System.currentTimeMillis() - startTime >= timeUntilFullyCharged){
                    cleaningRobot.setReady();
                    break;
                }
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
