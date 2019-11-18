package ReceiverDevices;

public class Microwave extends Device {
    private int timer = 0;
    private int temperatur = 0;

    private enum DeviceCommands {
        SwitchOn,
        SwitchOff,
        SetTimer,
        SetTemperature,
        SetUpProgram,
        StartBaking,
        CheckTimer,
        Interrupt
    }
    public void printDeviceMenu(){
        int i = 0;
        for (DeviceCommands commands : DeviceCommands.values()) {
            System.out.println("["+i+"]"+commands);
            i++;
        }
    }

}
