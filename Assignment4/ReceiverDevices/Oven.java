package ReceiverDevices;

public class Oven extends Device{

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
        System.out.println("----------");
        int i = 0;
        for (Oven.DeviceCommands commands : Oven.DeviceCommands.values()) {
            System.out.println("["+i+"] "+commands);
            i++;
        }
        System.out.println("back");
        System.out.println("----------");
    }

    public void turnOn() {
        //new Thread
        //start Thread
    }

    public void turnOff() {
        //kill Thread
    }
}
