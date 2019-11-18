package ReceiverDevices;

import CommandHandler.CommandHandler;
import CommandHandler.OvenCommandHandler;

public class Oven extends Device{

    public Oven() {

    }

    private int timer = 0;
    private int temperatur = 0;

    private enum OvenProgram {
        ventilated,
        grill,
        defrost
    }

    private enum DeviceStates {
        On,
        Off
    }

    public void turnOn() {
        //new Thread
        //start Thread
        System.out.println("Oven is on");
    }

    public void turnOff() {
        //kill Thread
    }
}
