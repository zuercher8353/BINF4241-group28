package ReceiverDevices;


public class MyThread implements Runnable {
    private boolean running;    // represent the state of the thread
    private int time;


    public MyThread(int timeInMillis){
        time = timeInMillis;
        running = false;
    }

    public boolean isRunning(){
        return running;
    }

    // do we need to check if threat is already running
    @Override
    public void run() {
        try {
            running = true;

            Thread.sleep(time);
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }




}
