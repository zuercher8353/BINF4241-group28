package ReceiverDevices;

public class Oven implements Device {
    private enum OvenProgram {
        ventilated,
        grill,
        defrost
    }

    private enum OvenCommands {
        SwitchOn,
        SwitchOff,
        SetTimer,
        SetTemperature,
        SetUpProgram,
        StartCooking,
        CheckTimer,
        Interrupt
    }

    private enum OvenStates {
        On,
        Off,
        Cooking,
    }

    public void printDeviceMenu(){
        for (OvenCommands commands : OvenCommands.values()) {
            System.out.println(commands);
        }
    }
    public void on() {

    }

    @Override
    public void off() {

    }
}
