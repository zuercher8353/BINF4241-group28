package ReceiverDevices;

public class Oven implements Device {

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
        Off,
        Cooking,
    }

    public void printDeviceMenu(){
        for (DeviceCommands commands : DeviceCommands.values()) {
            System.out.println(commands);
        }
    }

    public void on() {

    }

    @Override
    public void off() {

    }
}
