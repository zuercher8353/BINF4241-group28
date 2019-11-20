package ReceiverDevices;

import CommandHandler.*;

public class WashingMachine implements Device{

    private int timer = 0;

    public void switchOn() {

    }

    public void switchOff() {

    }

    public void interrupt() {

    }

    private enum Degrees {
        SET_DEGREE_HIGH(90),
        SET_DEGREE_MIDDLE(60),
        SET_DEGREE_LOW(40);

        private final int value;

        Degrees(final int newValue){
            value = newValue;
        }
        public int getValue() {return value;}
    }

    private enum WashingMachinePrograms{
        DoubleRinse,
        Intense,
        Quick,
        Spin
    }

    private enum DeviceStates {
        On,
        Off
    }


    public void turnOn(){
        System.out.println("Washing machine is on");
    }

}
