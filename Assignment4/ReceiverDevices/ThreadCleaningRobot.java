package ReceiverDevices;

public class ThreadCleaningRobot implements Runnable {
    private long timer;
    boolean running;
    CleaningRobot cleaningRobot;

    public ThreadCleaningRobot(long timeInMillis, CleaningRobot cleaningRobot){
        timer = timeInMillis;
        this.cleaningRobot = cleaningRobot;
        running = false;
    }


    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while(true){
            try {
                if(System.currentTimeMillis() - startTime >= timer){
                    cleaningRobot.startCharging();
                    break;
                }
                if(cleaningRobot.batteryStatusWithReturn() < 5){
                    cleaningRobot.remainingCleaning();
                    cleaningRobot.startCharging();
                    break;
                }
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
