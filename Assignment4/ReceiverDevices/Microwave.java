package ReceiverDevices;

public class Microwave {
    private int timer = 0;
    private int temperature = 0;

    private enum DeviceCommands {
        SwitchOn,
        SwitchOff,
        SetTimer,
        SetTemperature,
        SetUpProgram,
        StartBaking,
        CheckTimer,
        Interrupt
    }
    public void printDeviceMenu(){
        for (DeviceCommands commands : DeviceCommands.values()) {
            System.out.println(commands);
        }
    }
    private enum DeviceStates {
        On,
        Off,
        // ReadyToRun, don`t know about that
        Running,
        Ended
    }

}
