package ReceiverDevices;

public class Cleaningrobot implements Device, Runnable {

    @Override
    public void run() {
        try {
            deviceState = Oven.DeviceStates.On;
            Thread.sleep(timer);
            deviceState = Oven.DeviceStates.Off;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        Running,
        Charging,
        CleaningNotCompleted,
        Ended

    }
    public void SwitchOff() {
        //kill Thread
    }
    public void interrupt(){
        //stop running, but keep all variables, timer, program usw
    }

    public void SwitchOn() {
        Device device = new Device();
        //new Thread
        //start Thread
    }

    public void printDeviceMenu(){
        for (DeviceCommands commands : DeviceCommands.values()) {
            System.out.println(commands);
        }
    }
}
