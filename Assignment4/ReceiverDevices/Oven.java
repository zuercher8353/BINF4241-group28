package ReceiverDevices;


public class Oven extends Device implements Runnable{
    private int timer = 0;
    private int temperature = 0;
    private DeviceStates deviceState = DeviceStates.Off;

    @Override
    public void run() {
        try {
            deviceState = DeviceStates.On;
            Thread.sleep(timer);
            deviceState = DeviceStates.Off;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private enum DeviceStates {
        On,
        Off,
        Running
    }





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


    public void printDeviceMenu(){
        for (DeviceCommands commands : DeviceCommands.values()) {
            System.out.println(commands);
        }
    }



}
