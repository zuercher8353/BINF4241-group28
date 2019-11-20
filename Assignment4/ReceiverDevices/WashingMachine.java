package ReceiverDevices;

import CommandHandler.*;

import java.util.ArrayList;

public class WashingMachine implements Device{
    private int degree = -1;
    private long timer = -1;
    private DeviceStates deviceState = DeviceStates.Off;
    private WashingMachinePrograms washingMachineProgram = WashingMachinePrograms.NotSet;
    private long start;

    private enum Degrees {
        SET_DEGREE_HIGH(90),
        SET_DEGREE_MIDDLE(60),
        SET_DEGREE_LOW(40);

        private final int value;

        Degrees(final int newValue){
            value = newValue;
        }
        public int getValue() {return value;}
    }

    public enum WashingMachinePrograms{
        DoubleRinse,
        Intense,
        Quick,
        Spin,
        NotSet
    }

    public enum DeviceStates {
        On,
        Off,
        Running
    }

    public enum DeviceCommands {
        SwitchOn,
        SwitchOff,
        SetUpDegree,
        SetUpProgram,
        CheckTimer,
        StartWashing,
        Interrupt
    }

    public ArrayList getStateCommands(){
        ArrayList<String> possibleFunctions = new ArrayList<>();
        if (deviceState == DeviceStates.Off){
            possibleFunctions.add(DeviceCommands.SwitchOn.name());
        } else if(deviceState == DeviceStates.On){
            possibleFunctions.add(DeviceCommands.SetUpDegree.name());
            possibleFunctions.add(DeviceCommands.CheckTimer.name());
            possibleFunctions.add(DeviceCommands.SetUpProgram.name());
            possibleFunctions.add(DeviceCommands.SwitchOff.name());
            if(degree != -1 && washingMachineProgram == WashingMachinePrograms.NotSet) {
                possibleFunctions.add(DeviceCommands.StartWashing.name());
            }
        } else if (deviceState == DeviceStates.Running){
            possibleFunctions.add(DeviceCommands.Interrupt.name());
            possibleFunctions.add(DeviceCommands.CheckTimer.name());
        }
        return possibleFunctions;
    }


    public void switchOn(){
        if (deviceState == DeviceStates.Off){
            deviceState = DeviceStates.On;
        } else {
            System.out.println("Device is already switched on");
        }
    }

    public void setDegree(int deg){
        degree = deg;
    }

    public void setUpProgram(String program){
        for (WashingMachinePrograms ENUM_washingMachineProgams : WashingMachinePrograms.values()){
            if (ENUM_washingMachineProgams.toString().equals(program)){
                washingMachineProgram = ENUM_washingMachineProgams;
            }
        }
    }

    public void startWashing(){
        start = System.currentTimeMillis();
        deviceState = DeviceStates.Running;
        if (washingMachineProgram == WashingMachinePrograms.DoubleRinse){
            timer = 120000;
        } else if (washingMachineProgram == WashingMachinePrograms.Intense){
            timer = 7200000;
        } else if (washingMachineProgram == WashingMachinePrograms.Quick){
            timer = 1800000;
        } else if (washingMachineProgram == WashingMachinePrograms.Spin){
            timer = 600000;
        }
    }

    public void checkTimer(){
        if (deviceState == DeviceStates.Running){
            long remainingTimeSec = (timer - (System.currentTimeMillis() - start)) / 1000;
            if (remainingTimeSec <= 0){
                System.out.println("No time ramining, the program is finished");
            } else{
                int remaining = (int) remainingTimeSec;
                timer = remaining;
            }
        } else if(deviceState == DeviceStates.On){
            if (timer == -1){
                System.out.println("You did not set a timer yet");
            } else{
                int timerInSec = (int) (timer/1000);
            }
        }
    }
    public void switchOff(){
        degree = -1;
        timer = -1;
        deviceState = DeviceStates.Off;
        washingMachineProgram = WashingMachinePrograms.NotSet;
        start = 0;
    }

    public void interrupt(){
        if(deviceState == DeviceStates.Running){
            timer = -1;
            degree = -1;
            deviceState = DeviceStates.On;
            washingMachineProgram = WashingMachinePrograms.NotSet;
            start = 0;
        }
    }

}
