package ReceiverDevices;

public abstract class Device  {


    private enum DeviceCommands{}

    private enum DeviceStates{}




    public void printDeviceMenu(){
        for (DeviceCommands commands : DeviceCommands.values()) {
            System.out.println(commands);
        }
    }



    public void turnOn() {
        //new Thread
        //start Thread
    }

    public void turnOff() {
        //kill Thread
    }
    public void interrupt(){
        //stop running, but keep all variables, timer, program usw
    }











}
