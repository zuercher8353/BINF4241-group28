package ReceiverDevices;

public class Oven implements Device {

    private int timer = 0;
    private int temperatur = 0;

    private enum OvenProgram {
        ventilated,
        grill,
        defrost
    }

    private enum DeviceCommands {
        SwitchOn,
        SwitchOff,
        SetTimer,
        SetTemperature,
        SetUpProgram,
        StartCooking,
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

    public void turnOn() {
        //new Thread
        //start Thread
    }

    @Override
    public void turnOff() {
        //kill Thread
    }
}
