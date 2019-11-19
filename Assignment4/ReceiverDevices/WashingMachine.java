package ReceiverDevices;

import CommandHandler.*;

public class WashingMachine implements Device{

    private long timer = -1;
    private DeviceStates deviceState = DeviceStates.Off;
    private WashingMachinePrograms washingMachineProgram = WashingMachinePrograms.NotSet;

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

    private enum WashingMachinePrograms{
        DoubleRinse,
        Intense,
        Quick,
        Spin,
        NotSet
    }

    private enum DeviceStates {
        On,
        Off,
        Running
    }


    public void SwitchOn(){
        if (deviceState == DeviceStates.Off){
            deviceState = DeviceStates.On;
        } else {
            System.out.println("Washing machine is already switched on");
        }
    }

    public void SwitchOff(){
        timer = -1;
        deviceState = DeviceStates.Off;
        washingMachineProgram = WashingMachinePrograms.NotSet;
    }

    public void interrupt(){
        if(deviceState == DeviceStates.Running){
            timer = -1;
            deviceState = DeviceStates.On;
            washingMachineProgram = WashingMachinePrograms.NotSet;
        }
    }

}
