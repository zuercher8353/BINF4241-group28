package ReceiverDevices;
import java.util.*;
import Threads .*;

public class CleaningRobot{

    private long timer = -1;
    private long startTime = -1;
    private long remainingCleaningTime = -1;
    private DeviceStates deviceState = DeviceStates.Ready;
    private Thread cleaningThread;
    private Thread chargingThread;


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
        }
        else if(deviceState == DeviceStates.CleaningNotCompleted){
            possibleFunctions.add(DeviceCommands.CompleteOutstandingCleaning.name());
            possibleFunctions.add(DeviceCommands.EndCleaning.name());
            // dont know if possible need to change so that it works possibleFunctions.add(DeviceCommands.CheckBatteryStatus.name());
        }
        return possibleFunctions;
    }
    public void setTimer(int timeInSec){
        timer = (long) 1000*timeInSec;
    }

    public void startCleaner(){
        deviceState = DeviceStates.Running;
        startTime =  System.currentTimeMillis();
        ThreadCleaningRobot cleaningThreadBehaviour = new ThreadCleaningRobot(timer, this);
        cleaningThread = new Thread(cleaningThreadBehaviour, "cleaningThread");
        cleaningThread.start();
    }
    public void setRemainingCleaning(long remaining){
        remainingCleaningTime = remaining;
    }


    public void startCharging(){
        cleaningThread = null;
        deviceState = DeviceStates.Charging;
        float batteryBeforeCharging =  batteryStatusWithReturn();
        startTime = -1;
        long batteryChargingTime = (100 - (long)batteryBeforeCharging) * 1000;
        ThreadChargingRobot cleaningThreadBehaviour = new ThreadChargingRobot(batteryChargingTime, this);
        chargingThread = new Thread(cleaningThreadBehaviour, "cleaningThread");
        chargingThread.start();

        //start threat so that when fully charged changes to ready

    }
    //only possible while running
    public void checkCleaningCompletion(){
        long timeNow = System.currentTimeMillis();
        if(remainingCleaningTime == -1){
            long percentageCleaned = (timeNow - startTime) / timer *100;
            int percentage = (int) percentageCleaned;
            System.out.println("The percentage of cleaning completion is " + percentage + "%");
        }
        else{
            long percentageCleaned = (remainingCleaningTime - (timeNow - startTime)) / timer *100;
            int percentage = (int) percentageCleaned;
            System.out.println("The percentage of cleaning completion is " + percentage + "%");
        }
    }

    //roboter loses 1 percent of battery per second.
    public void checkBatteryStatus(){
        if(deviceState == DeviceStates.Ready){
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
        long timeNow = System.currentTimeMillis();
        float chargingStatus = 0;
    }

    public void setReady() {
        chargingThread = null;
        if(remainingCleaningTime != -1){
            deviceState = DeviceStates.CleaningNotCompleted;
        }
        else {
            deviceState = DeviceStates.Ready;
            timer = -1;
        }
    }

    public void interrupt() {
        long timer = -1;
        long remainingCleaningTime = -1;
        this.startCharging();

    }






}
