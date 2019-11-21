package ReceiverDevices;


import Threads.DishwasherThread;

import java.util.ArrayList;

public class Dishwasher implements Device {

    private long timer = -1;
    private DeviceStates deviceState = DeviceStates.Off;
    private DishwasherPrograms dishwasherProgram = DishwasherPrograms.notSet;
    private long start;
    private Thread dishwasherThread;
    DishwasherThread dishwasherThreadBehaviour;

    public enum DishwasherPrograms {
        Glasses,
        Plates,
        Pans,
        Mixed,
        notSet
    }

    public enum DeviceCommands {
        SwitchOn,
        SwitchOff,
        StartWashing,
        SetUpProgram,
        CheckTimer,
        Stop,
    }

    private enum DeviceStates {
        On,
        Off,
        Running,
        Ended
    }

    public ArrayList getStateCommands(){
        ArrayList<String> possibleFunctions = new ArrayList<>();
        if (deviceState == DeviceStates.Off){
            possibleFunctions.add(DeviceCommands.SwitchOn.name());
        } else if(deviceState == DeviceStates.On) {
            possibleFunctions.add(DeviceCommands.CheckTimer.name());
            possibleFunctions.add(DeviceCommands.SetUpProgram.name());
            possibleFunctions.add(DeviceCommands.SwitchOff.name());

            if (dishwasherProgram == DishwasherPrograms.notSet){
                possibleFunctions.add(DeviceCommands.StartWashing.name());
            }
        } else if (deviceState == DeviceStates.Running){
            possibleFunctions.add(DeviceCommands.Stop.name());
            possibleFunctions.add(DeviceCommands.CheckTimer.name());
        }
        return possibleFunctions;
    }

    public void SwitchOn(){
        deviceState = DeviceStates.On;
    }

    public void setUpProgram(DishwasherPrograms program){
        for (Dishwasher.DishwasherPrograms ENUM_dishwasherProgams : DishwasherPrograms.values()) {
            if (ENUM_dishwasherProgams.toString().equals(program)) {
                dishwasherProgram = ENUM_dishwasherProgams;
            }
        }
    }

    public void startWashing(){
        if (dishwasherProgram.equals(DishwasherPrograms.notSet)) {
            System.out.println("you must set a program");
        } else {
            if (dishwasherProgram == DishwasherPrograms.Glasses) {
                timer = 3600000;
            } else if (dishwasherProgram == DishwasherPrograms.Mixed) {
                timer = 7200000;
            } else if (dishwasherProgram == DishwasherPrograms.Pans) {
                timer = 5400000;
            } else if (dishwasherProgram == DishwasherPrograms.Plates) {
                timer = 4200000;
            }
            start = System.currentTimeMillis();
            dishwasherThreadBehaviour = new DishwasherThread(timer, this);
            dishwasherThread = new Thread(dishwasherThreadBehaviour, "dishwasherThread");
            dishwasherThread.start();
            deviceState = DeviceStates.Running;
        }
    }

    public void checkTimer() {
        if (deviceState == DeviceStates.Running){
            long remainingTimeSec = (timer - (System.currentTimeMillis() - start)) / 1000;
            if (remainingTimeSec <= 0){
                System.out.println("No time remaining, the program is finished");
            } else{
                int remaining = (int) remainingTimeSec;
                timer = remaining;
            }
        } else if (deviceState == DeviceStates.On){
            if (timer == -1){
                System.out.println("You did not set a timer");
            } else{
                int timerInSec = (int) timer/1000;
            }
        }
    }

    public void SwitchOff(){
        timer = -1;
        deviceState = DeviceStates.Off;
        dishwasherProgram = DishwasherPrograms.notSet;
        start = 0;
    }

    public void interrupt(){
        if(deviceState == DeviceStates.Running){
            dishwasherThreadBehaviour.stop();
            dishwasherThread = null;
            timer = -1;
            deviceState = DeviceStates.On;
            dishwasherProgram = DishwasherPrograms.notSet;
            start = 0;
        }
    }

    public void setEnded() {
        deviceState = DeviceStates.Ended;
    }
}
