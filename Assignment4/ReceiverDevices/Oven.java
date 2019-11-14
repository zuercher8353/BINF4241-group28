package ReceiverDevices;

public class Oven extends Device{

    private int timer = 0;
    private int temperatur = 0;

    private enum OvenProgram {
        ventilated,
        grill,
        defrost
    }
    @Override
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

    @Override
    private enum DeviceStates {
        On,
        Off
    }


}
