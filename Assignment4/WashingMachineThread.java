import ReceiverDevices.WashingMachine;

public class WashingMachineThread implements Runnable{
    private long washingTime;
    WashingMachine washingMachine;

    public WashingMachineThread(long washingTime, WashingMachine washingmachine){
        this.washingTime = washingTime;
        this.washingMachine = washingmachine;
    }

    @Override
    public void run(){
        try{
            Thread.sleep(1);
            washingMachine.setEnded();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
