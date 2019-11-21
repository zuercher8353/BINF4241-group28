package ReceiverDevices;

import Threads.*;

import java.util.ArrayList;

public class Microwave implements Device {

    public enum DeviceCommands {
        SwitchOn,
        SwitchOff,
        SetTimer,
        SetTemperature,
        StartBaking,
        CheckTimer,
        Interrupt
    }

    private long timer = -1;
    private int temperature = -1;
    private Microwave.DeviceStates deviceState = Microwave.DeviceStates.Off;
    private long start;
    private Thread microwaveThread;
    private MicrowaveThread microwaveThreadBehaviour;

    private enum DeviceStates {
        On,
        Off,
        Running,
        Ended
    }

    public ArrayList getStateCommands() {
        ArrayList<String> possibleFunctions = new ArrayList<String>();
        if (deviceState == Microwave.DeviceStates.Off) {
            possibleFunctions.add(Microwave.DeviceCommands.SwitchOn.name());
        } else if (deviceState == Microwave.DeviceStates.On || deviceState == Microwave.DeviceStates.Ended) {
            possibleFunctions.add(Microwave.DeviceCommands.SwitchOff.name());
            possibleFunctions.add(Microwave.DeviceCommands.SetTemperature.name());
            possibleFunctions.add(Microwave.DeviceCommands.CheckTimer.name());
            possibleFunctions.add(Microwave.DeviceCommands.SetTimer.name());
            if (temperature != -1 && timer != -1) {
                possibleFunctions.add(Microwave.DeviceCommands.StartBaking.name());
            }

        } else if (deviceState == Microwave.DeviceStates.Running) {
            possibleFunctions.add(Microwave.DeviceCommands.Interrupt.name());
            possibleFunctions.add(Microwave.DeviceCommands.SwitchOff.name());
            possibleFunctions.add(Microwave.DeviceCommands.CheckTimer.name());
        }

        return possibleFunctions;
    }

    public void setEnded() {
        microwaveThread = null;
        deviceState = Microwave.DeviceStates.Ended;
    }

    public void switchOn() {
        if (deviceState == Microwave.DeviceStates.Off) {
            deviceState = Microwave.DeviceStates.On;
        } else {
            System.out.println("Device is already switched on");
        }
    }

    public void setTimer(int time) {
        if (deviceState == Microwave.DeviceStates.On) {
            timer = (long) time * 1000;
        } else if (deviceState == Microwave.DeviceStates.Off) {
            System.out.println("You need to switch the Microwave on before you set a timer");
        } else if (deviceState == Microwave.DeviceStates.Running) {
            System.out.println("The Microwave is running you cant set a timer");
        }
    }

    public void setTemperature(int temp) {
        if (deviceState == Microwave.DeviceStates.On) {
            temperature = temp;
        } else if (deviceState == Microwave.DeviceStates.Off) {
            System.out.println("You need to switch the Microwave on before you set a temperature");
        } else if (deviceState == Microwave.DeviceStates.Running) {
            System.out.println("The Microwave is running, you cant set a temperature");
        }
    }

    public void startBaking() {

        if (temperature != -1 && timer != -1) {
            start = System.currentTimeMillis();
            microwaveThreadBehaviour = new MicrowaveThread(timer, this);
            microwaveThread = new Thread(microwaveThreadBehaviour, "microwaveThread");
            microwaveThread.start();
            deviceState = Microwave.DeviceStates.Running;
        } else {
            System.out.println("Not all parameters are set you can`t start cooking");
        }

        if (deviceState == Microwave.DeviceStates.Off) {
            System.out.println("You need to switch the Microwave on before you can start cooking");
        } else if (deviceState == Microwave.DeviceStates.Running) {
            //System.out.println("The Microwave is already cooking");
        }
    }

    public void checkTimer() {
        //returns remaining time if program is running else it returns the last timer set
        if (deviceState == Microwave.DeviceStates.Running) {

            long remainingTimeSec = (timer - (System.currentTimeMillis() - start)) / 1000;
            if (remainingTimeSec <= 0) {
                System.out.println("No time remaining, the program is finished");
            } else {
                int remaining = (int) remainingTimeSec;
                System.out.println("Remaining Time: " + remaining);
            }
        } else if (deviceState == Microwave.DeviceStates.Off) {
            System.out.println("You need to switch the Microwave, to check the timer");
        } else if (deviceState == Microwave.DeviceStates.On || deviceState == Microwave.DeviceStates.Ended) {
            if (timer == -1) {
                System.out.println("You did not set a timer yet");
            } else {
                int timerInSec = (int) (timer / 1000);
                System.out.println("Set Time: " + timerInSec);
            }
        }

    }

    public void interrupt() {
        if (deviceState == Microwave.DeviceStates.Running) {
            microwaveThreadBehaviour.stop();
            microwaveThread = null;
            timer = -1;
            temperature = -1;
            deviceState = Microwave.DeviceStates.On;
            start = 0;
        } else {
            System.out.println("The Microwave is not in operation, you can´t interrupt");
        }
    }

    //allowed to switch off if program still running?
    public void switchOff() {
        timer = -1;
        temperature = -1;
        deviceState = Microwave.DeviceStates.Off;
        start = 0;
    }
}
