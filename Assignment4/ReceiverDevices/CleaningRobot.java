package ReceiverDevices;
import java.util.*;

public class CleaningRobot{

    long timer = -1;
    long startTime = -1;
    long chargingStartTime = -1;
    long remainingCleaning = -1;
    float batteryStatusInPercent = 100;
    DeviceStates deviceState = DeviceStates.Ready;
    boolean fullyCharged = true;
    float batteryBeforeCharging;

    private enum DeviceCommands {
        SetTimer,
        StartCleaner,
        CheckPercentageOfCleaningCompletion,
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
        Ended

    }
    public ArrayList getStateCommands() {
        ArrayList<String> possibleFunctions = new ArrayList<String>();
        if (deviceState == DeviceStates.Running){
            possibleFunctions.add(DeviceCommands.CheckPercentageOfCleaningCompletion.name());
            possibleFunctions.add(DeviceCommands.EndCleaning.name());
            possibleFunctions.add(DeviceCommands.CheckBatteryStatus.name());
            if(remainingTime > -1){
                possibleFunctions.add(DeviceCommands.CompleteOutstandingCleaning.name());
            }

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
            possibleFunctions.add(Oven..SwitchOff.name());
            possibleFunctions.add(Oven.DeviceCommands.CheckTimer.name());
        }
        return possibleFunctions;
    }
    public void setTimer(int timeInSec){
        timer = (long) 1000*timeInSec;
    }

    public void startCleaner(){
        deviceState = DeviceStates.Running;
        startTime =  System.currentTimeMillis();
        fullyCharged = false;
        ThreadCleaningRobot cleaningThreadBehaviour = new ThreadCleaningRobot(timer, this);
        Thread cleaningThread = new Thread(cleaningThreadBehaviour, "cleaningThread");
        cleaningThread.start();
    }
    public void remainingCleaning(){
        long timeNow = System.currentTimeMillis();
        long remaining = timer - (timeNow - startTime);
        if(remaining > 0){
            timer = remaining;
        }
        else{
            timer = -1;
        }
    }
    public void startCharging(){
        deviceState = DeviceStates.Charging;
        batteryBeforeCharging =  batteryStatusWithReturn();
        chargingStartTime =  System.currentTimeMillis();
        //start threat so that when fully charged changes to ready



    }
    //only possible while running
    public void checkPercentageOfCleaningCompletion(){
        long timeNow = System.currentTimeMillis();
        long percentageCleaned = (timeNow - startTime) / timer *100;
        int percentage = (int) percentageCleaned;
        System.out.println("The percentage of cleaning completion is " + percentage + "%");
    }

    //roboter loses 1 percent of battery per second.
    public void CheckBatteryStatus(){
        long timeNow = System.currentTimeMillis();
        float batteryUsed =  (float) (timeNow - startTime) /1000;
        float batteryStatus = 100 - batteryUsed;
        System.out.println("The battery status is " + batteryStatus + "%");
    }

    public float batteryStatusWithReturn(){
        long timeNow = System.currentTimeMillis();
        float batteryUsed =  (float) (timeNow - startTime) /1000;
        return 100 - batteryUsed;
    }
    public void CheckBatteryChargingStatus(){
        long timeNow = System.currentTimeMillis();
        float chargingStatus = 0;
    }

    public void setDeviceState(DeviceStates deviceState) {
        this.deviceState = deviceState;
    }

    public void  completeOutstandingCleaning(){

    }
    public void endCleaning(){

    }





}
