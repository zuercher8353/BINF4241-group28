package ReceiverDevices;


import Threads.DishwasherThread;

import java.util.ArrayList;

public class Dishwasher implements Devices, WashingDevices {

    private long timer = -1;
    private DeviceStates deviceState = DeviceStates.Off;
    private DishwasherPrograms dishwasherProgram = DishwasherPrograms.notSet;
    private long start;
    private Thread dishwasherThread;
    private DishwasherThread dishwasherThreadBehaviour;

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
        } else if(deviceState == DeviceStates.On || deviceState == DeviceStates.Ended) {
            possibleFunctions.add(DeviceCommands.CheckTimer.name());
            possibleFunctions.add(DeviceCommands.SetUpProgram.name());
            possibleFunctions.add(DeviceCommands.SwitchOff.name());

            if (dishwasherProgram != DishwasherPrograms.notSet){
                possibleFunctions.add(DeviceCommands.StartWashing.name());
            }
        } else if (deviceState == DeviceStates.Running){
            possibleFunctions.add(DeviceCommands.Stop.name());
            possibleFunctions.add(DeviceCommands.CheckTimer.name());
            possibleFunctions.add(DeviceCommands.SwitchOff.name());
        }
        return possibleFunctions;
    }

    public void switchOn(){
        deviceState = DeviceStates.On;
    }

    public void setUpProgram(String program){
        for (DishwasherPrograms ENUM_dishwasherProgams : DishwasherPrograms.values()) {
            if (ENUM_dishwasherProgams.toString().equals(program)) {
                dishwasherProgram = ENUM_dishwasherProgams;
            }
        }
        if (dishwasherProgram == DishwasherPrograms.Glasses) {
            timer = 36000;
        } else if (dishwasherProgram == DishwasherPrograms.Mixed) {
            timer = 72000;
        } else if (dishwasherProgram == DishwasherPrograms.Pans) {
            timer = 54000;
        } else if (dishwasherProgram == DishwasherPrograms.Plates) {
            timer = 42000;
        }
    }

    public void startWashing(){
        start = System.currentTimeMillis();
        deviceState = DeviceStates.Running;
        dishwasherThreadBehaviour = new DishwasherThread(timer, this);
        dishwasherThread = new Thread(dishwasherThreadBehaviour, "dishwasherThread");
        dishwasherThread.start();
    }

    public void checkTimer() {
        if (deviceState == DeviceStates.Running){
            long remainingTimeSec = (timer - (System.currentTimeMillis() - start)) / 1000;
            if (remainingTimeSec <= 0){
                System.out.println("No time remaining, the program is finished");
            } else{
                int remaining = (int) remainingTimeSec;
                System.out.println("Remaining time: " + remaining);

            }
        } else if (deviceState == DeviceStates.On || deviceState == DeviceStates.Ended){
            if (timer == -1){
                System.out.println("You did not set a program yet");
            } else{
                int timerInSec = (int) timer/1000;
                System.out.println("Set time: " + timerInSec);
            }
        }
    }

    public void switchOff(){
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
        dishwasherThread = null;
        deviceState = DeviceStates.Ended;
    }
}
