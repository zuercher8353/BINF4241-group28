package ReceiverDevices;

public class Dishwasher implements Device, Runnable {

    private int timer = 0;

    @Override
    public void SwitchOn() {

    }

    @Override
    public void SwitchOff() {

    }

    @Override
    public void interrupt() {

    }

    @Override
    public void run() {

    }

    private enum DishwasherProgram {
        Glasses,
        Plates,
        Pans,
        Mixed
    }

    private enum DeviceCommands {
        SwitchOn,
        SwitchOff,
        StartDishwasher,
        SetUpProgram,
        CheckTimer,
        Interrupt
    }

    private enum DeviceStates {
        On,
        Off
    }

    public void printDeviceMenu() {
        for (DeviceCommands commands : DeviceCommands.values()) {
            System.out.println(commands);
        }
    }

}
