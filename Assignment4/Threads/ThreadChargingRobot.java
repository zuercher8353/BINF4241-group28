package Threads;

import ReceiverDevices.CleaningRobot;

public class ThreadChargingRobot implements Runnable {
    private long timeUntilFullyCharged;
    private CleaningRobot cleaningRobot;

    public ThreadChargingRobot(long timeUntilFullyCharged, CleaningRobot cleaningRobot){
        this.timeUntilFullyCharged = timeUntilFullyCharged;
        this.cleaningRobot = cleaningRobot;
    }


    @Override
    public void run() {
    try {
        Thread.sleep(timeUntilFullyCharged);
        cleaningRobot.setReady();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

   }


}
