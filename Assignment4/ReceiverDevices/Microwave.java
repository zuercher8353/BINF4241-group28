package ReceiverDevices;

public class Microwave implements Device, Runnable {
    private long timer = -1;
    private int temperature = -1;
    private DeviceStates deviceState = Microwave.DeviceStates.Off;

    private long start;

    public enum DeviceCommands {
        SwitchOn,
        SwitchOff,
        SetTimer,
        SetTemperature,
        SetUpProgram,
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
