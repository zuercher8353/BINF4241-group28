package ReceiverDevices;

public class Microwave implements Device, Runnable {
    private long timer = -1;
    private int temperature = -1;
    private Microwave.DeviceStates deviceState = Microwave.DeviceStates.Off;
    private Oven.OvenProgram ovenProgram = Oven.OvenProgram.notSet;
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

    public void run() {

    }

    public void switchOn() {

    }

    public void switchOff() {

    }

    public void interrupt() {

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
