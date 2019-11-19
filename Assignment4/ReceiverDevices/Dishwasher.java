package ReceiverDevices;

public class Dishwasher implements Device, Runnable{

    private int timer = 0;

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

    public void printDeviceMenu(){
        for (DeviceCommands commands : DeviceCommands.values()) {
            System.out.println(commands);
        }
    }

}
