package ReceiverDevices;


import java.util.ArrayList;

public class Dishwasher implements Device {

    private long timer = -1;
    private DeviceStates deviceState = DeviceStates.Off;
    private DishwasherPrograms dishwasherProgram = DishwasherPrograms.NotSet;
    private long start;

    public enum DishwasherPrograms {
        Glasses,
        Plates,
        Pans,
        Mixed,
        NotSet
    }

    public enum DeviceCommands {
        SwitchOn,
        SwitchOff,
        StartWashing,
        SetUpProgram,
        CheckTimer,
        Stop
    }

    private enum DeviceStates {
        On,
        Off,
        Running
    }

    public ArrayList getStateCommands(){
        ArrayList<String> possibleFunctions = new ArrayList<>();

        if (deviceState == DeviceStates.Off){
            possibleFunctions.add(DeviceCommands.SwitchOn.name());
        } else if(deviceState == DeviceStates.On) {
            possibleFunctions.add(DeviceCommands.CheckTimer.name());
            possibleFunctions.add(DeviceCommands.SetUpProgram.name());
            possibleFunctions.add(DeviceCommands.SwitchOff.name());

            if (dishwasherProgram == DishwasherPrograms.NotSet){
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
        dishwasherProgram = program;
    }

    public void startWashing(){
        start = System.currentTimeMillis();
        deviceState = DeviceStates.Running;
        if (dishwasherProgram == DishwasherPrograms.Glasses){
            timer = 3600000;
        } else if (dishwasherProgram == DishwasherPrograms.Mixed){
            timer = 7200000;
        } else if (dishwasherProgram == DishwasherPrograms.Pans){
            timer = 5400000;
        } else if (dishwasherProgram == DishwasherPrograms.Plates){
            timer = 4200000;
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
        dishwasherProgram = DishwasherPrograms.NotSet;
        start = 0;
    }

    public void interrupt(){
        if(deviceState == DeviceStates.Running){
            timer = -1;
            deviceState = DeviceStates.On;
            dishwasherProgram = DishwasherPrograms.NotSet;
            start = 0;
        }
    }
}
