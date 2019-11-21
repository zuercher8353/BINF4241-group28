package Threads;

import ReceiverDevices.CleaningRobot;

public class ThreadChargingRobot implements Runnable {
    private long timeUntilFullyCharged;
    private CleaningRobot cleaningRobot;
    private boolean run;

    public ThreadChargingRobot(long timeUntilFullyCharged, CleaningRobot cleaningRobot){
        this.timeUntilFullyCharged = timeUntilFullyCharged;
        this.cleaningRobot = cleaningRobot;
        this.run = true;
    }


    @Override
    public void run() {
        while(run) {
            try {
                Thread.sleep(timeUntilFullyCharged);
                cleaningRobot.setReady();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

   }

    public void stop(){
        this.run = false;
    }


}
