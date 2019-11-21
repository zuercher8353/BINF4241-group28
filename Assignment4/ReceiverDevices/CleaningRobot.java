package ReceiverDevices;
import java.util.*;
import Threads .*;

public class CleaningRobot implements Devices{

    private long timer = -1;
    private long startTime = -1;
    private long startTimeCharging = -1;
    private long remainingCleaningTime = -1;
    private float remainingCleaning = -1;
    private float batteryBeforeCharging =-1;
    private DeviceStates deviceState = DeviceStates.Ready;
    private Thread cleaningThread;
    private Thread chargingThread;
    private ThreadCleaningRobot cleaningThreadBehaviour = null;
    private ThreadChargingRobot chargingThreadBehaviour = null;



    public enum DeviceCommands {
        SetTimer,
        StartCleaner,
        CheckCleaningCompletion,
        CheckBatteryStatus,
        CheckBatteryChargingStatus,
        CompleteOutstandingCleaning,
        EndCleaning
    }
    private enum DeviceStates {
        Ready,
        Running,
        Charging,
        CleaningNotCompleted,
        // add check ended when in charging Ended

    }
    public ArrayList getStateCommands() {
        ArrayList<String> possibleFunctions = new ArrayList<String>();
        if (deviceState == DeviceStates.Running){
            possibleFunctions.add(DeviceCommands.CheckCleaningCompletion.name());
            possibleFunctions.add(DeviceCommands.EndCleaning.name());
            possibleFunctions.add(DeviceCommands.CheckBatteryStatus.name());
            /*if(remainingCleaningTime > -1){
                possibleFunctions.add(DeviceCommands.CompleteOutstandingCleaning.name());
            }*/

        }
        else if(deviceState == DeviceStates.Ready){
            possibleFunctions.add(DeviceCommands.SetTimer.name());
            possibleFunctions.add(DeviceCommands.CheckBatteryStatus.name());
            //possibleFunctions.add(DeviceCommands.CheckBatteryChargingStatus.name()); dont know if possible
            if(timer != -1 ){
                possibleFunctions.add(DeviceCommands.StartCleaner.name());
            }

        } else if(deviceState == DeviceStates.Charging){
            possibleFunctions.add(DeviceCommands.CheckBatteryChargingStatus.name());
            if(remainingCleaning != -1){
                possibleFunctions.add(DeviceCommands.CheckCleaningCompletion.name());
            }
        }
        else if(deviceState == DeviceStates.CleaningNotCompleted){
            possibleFunctions.add(DeviceCommands.CompleteOutstandingCleaning.name());
            possibleFunctions.add(DeviceCommands.EndCleaning.name());
            possibleFunctions.add(DeviceCommands.CheckBatteryStatus.name());
            possibleFunctions.add(DeviceCommands.CheckCleaningCompletion.name());
        }
        return possibleFunctions;
    }
    public void setTimer(int timeInSec){
        timer = (long) 1000*timeInSec;
    }

    public void startCleaner(){
        deviceState = DeviceStates.Running;
        startTime =  System.currentTimeMillis();
        if(remainingCleaningTime == -1){
            cleaningThreadBehaviour = new ThreadCleaningRobot(timer, this);

        }
        else{
            cleaningThreadBehaviour = new ThreadCleaningRobot(remainingCleaningTime, this);
        }
        cleaningThread = new Thread(cleaningThreadBehaviour, "cleaningThread");
        cleaningThread.start();
    }
    public void setRemainingCleaning(long remaining){

        if(remaining == -1){
            remainingCleaning = -1;
        }
        else{
            remainingCleaning = (1 - (float)remaining / timer) *100;
        //this.checkCleaningCompletionWithReturn();
        }
        remainingCleaningTime = remaining;
    }



    public void startCharging(){
        cleaningThread = null;
        startTimeCharging = System.currentTimeMillis();
        deviceState = DeviceStates.Charging;
        batteryBeforeCharging =  batteryStatusWithReturn();
        startTime = -1;
        long batteryChargingTime = (100 - (long)batteryBeforeCharging) * 1000;
        chargingThreadBehaviour = new ThreadChargingRobot(batteryChargingTime, this);
        chargingThread = new Thread(chargingThreadBehaviour, "chargingThread");
        chargingThread.start();

        //start threat so that when fully charged changes to ready



    }
    //only possible while running

    public float checkCleaningCompletionWithReturn(){

        long timeNow = System.currentTimeMillis();
        if (remainingCleaningTime == -1) {
            float percentageCleaned = (float) (timeNow - startTime) / timer * 100;
            return percentageCleaned;
        } else {
            float percentageCleaned = (float) (remainingCleaningTime - (timeNow - startTime)) / timer * 100;
            return percentageCleaned;
        }

    }

    public void checkCleaningCompletion(){
        if(deviceState == DeviceStates.Charging){
            if(remainingCleaning != -1){

                System.out.println("The percentage of cleaning completion is " + remainingCleaning + "%");
            }
        }
        else if(deviceState == DeviceStates.CleaningNotCompleted){
            System.out.println("The percentage of cleaning completion is " + remainingCleaning + "%");
        }
        else {
            long timeNow = System.currentTimeMillis();
            if (remainingCleaningTime == -1) {
                float percentageCleaned = (float) (timeNow - startTime) / timer * 100;
                percentageCleaned = Math.min(percentageCleaned, 100);

                System.out.println("The percentage of cleaning completion is " + percentageCleaned + "%");
            } else {
                float percentageCleaned = (float) (timer - (remainingCleaningTime - (timeNow - startTime))) / timer * 100;
                percentageCleaned = Math.min(percentageCleaned, 100);
                System.out.println("The percentage of cleaning completion is " + percentageCleaned + "%");
            }
        }
    }

    //roboter loses 1 percent of battery per second.
    public void checkBatteryStatus(){
        if(deviceState == DeviceStates.Ready || deviceState == DeviceStates.CleaningNotCompleted ){
            System.out.println("The battery status is 100% charged");
        }
        else{
            long timeNow = System.currentTimeMillis();
            float batteryUsed =  (float) (timeNow - startTime) /1000;
            float batteryStatus = 100 - batteryUsed;
            System.out.println("The battery status is " + batteryStatus + "%");
        }
    }

    public float batteryStatusWithReturn(){
        long timeNow = System.currentTimeMillis();
        float batteryUsed =  (float) (timeNow - startTime) /1000;
        return 100 - batteryUsed;
    }
    public void checkBatteryChargingStatus(){
        long timeCharged = System.currentTimeMillis() - startTimeCharging;
        float chargingStatus = batteryBeforeCharging + ((float)timeCharged / 1000);
        chargingStatus = Math.min(chargingStatus,100);
        System.out.println("the battery is " + chargingStatus + "% charged");
    }

    public void setReady() {
        chargingThreadBehaviour.stop();
        chargingThread = null;
        startTime = -1;
        if(remainingCleaningTime != -1){
            deviceState = DeviceStates.CleaningNotCompleted;
        }
        else {
            deviceState = DeviceStates.Ready;
            timer = -1;
        }
    }

    public void interrupt() {
        if(cleaningThreadBehaviour != null){
            cleaningThreadBehaviour.stop(); }
        cleaningThread = null;
        if(chargingThreadBehaviour != null){
            chargingThreadBehaviour.stop(); }
        chargingThread = null;
        timer = -1;
        startTimeCharging = -1;
        remainingCleaningTime = -1;
        remainingCleaning = -1;
        batteryBeforeCharging =-1;
        if(deviceState == DeviceStates.CleaningNotCompleted){
            setReady();
        }
        else{
            this.startCharging();
        }


    }






}
