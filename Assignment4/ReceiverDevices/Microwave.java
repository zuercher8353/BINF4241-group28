package ReceiverDevices;

public class Microwave implements Device {
    private int timer = 0;
    private int temperature = 0;



    private enum DeviceCommands {
        SwitchOn,
        SwitchOff,
        SetTimer,
        SetTemperature,
        StartBaking,
        CheckTimer,
        Interrupt
    }

    private enum DeviceStates {
        On,
        Off,
        // ReadyToRun, don`t know about that
        Running,
        Ended
    }

    public void switchOn() {

    }

    public void switchOff() {

    }


    public void interrupt() {

    }


}
