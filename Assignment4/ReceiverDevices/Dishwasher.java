package ReceiverDevices;

public class Dishwasher extends Device{

    private int timer = 0;
    private int temperatur = 0;

    private enum DishwasherProgram {
        glasses,
        plates,
        pans,
        mixed
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
