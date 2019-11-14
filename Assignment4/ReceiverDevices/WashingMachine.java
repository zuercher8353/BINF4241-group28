package ReceiverDevices;

public class WashingMachine extends Device{

    private int timer = 0;

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
        Spin
    }

    private enum DeviceCommands {
        SwitchOn,
        SwitchOff,
        SetUpDegree,
        SetUpProgram,
        CheckTimer,
        Interrupt
    }

    private enum DeviceStates {
        On,
        Off
    }

    public void printDeviceMenu(){
        for (DeviceCommands commands : DeviceCommands.values()) {
            System.out.println(commands);
        }
    }

}
