package ReceiverDevices;

import Threads.WashingMachineThread;

import java.util.ArrayList;

public class WashingMachine implements Devices {
    private int degree = -1;
    private long timer = -1;
    private DeviceStates deviceState = DeviceStates.Off;
    private WashingMachinePrograms washingMachineProgram = WashingMachinePrograms.notSet;
    private long start;
    private Thread washingThread;
    private WashingMachineThread washingMachineThreadBehaviour;


    public enum WashingMachinePrograms {
        DoubleRinse,
        Intense,
        Quick,
        Spin,
        notSet
    }

    public enum DeviceStates {
        On,
        Off,
        Running,
        Ended
    }

    public enum DeviceCommands {
        SwitchOn,
        SwitchOff,
        SetUpDegree,
        SetUpProgram,
        CheckTimer,
        StartWashing,
        Interrupt
    }

    public ArrayList getStateCommands() {
        ArrayList<String> possibleFunctions = new ArrayList<>();
        if (deviceState == DeviceStates.Off) {
            possibleFunctions.add(DeviceCommands.SwitchOn.name());
        } else if (deviceState == DeviceStates.On || deviceState == DeviceStates.Ended) {
            possibleFunctions.add(DeviceCommands.SetUpDegree.name());
            possibleFunctions.add(DeviceCommands.CheckTimer.name());
            possibleFunctions.add(DeviceCommands.SetUpProgram.name());
            possibleFunctions.add(DeviceCommands.SwitchOff.name());
            if (degree != -1 && washingMachineProgram != WashingMachinePrograms.notSet) {
                possibleFunctions.add(DeviceCommands.StartWashing.name());
            }
        } else if (deviceState == DeviceStates.Running) {
            possibleFunctions.add(DeviceCommands.Interrupt.name());
            possibleFunctions.add(DeviceCommands.CheckTimer.name());
        }
        return possibleFunctions;
    }


    public void switchOn() {
        deviceState = DeviceStates.On;
    }

    public void setDegree(int deg) {
        degree = deg;
    }

    public void setEnded() {
        washingThread = null;
        deviceState = DeviceStates.Ended;
    }

    public void setUpProgram(String program) {
        for (WashingMachinePrograms ENUM_washingMachineProgams : WashingMachinePrograms.values()) {
            if (ENUM_washingMachineProgams.toString().equals(program)) {
                washingMachineProgram = ENUM_washingMachineProgams;
            }
        }
        if (washingMachineProgram == WashingMachinePrograms.DoubleRinse) {
            timer = 120000;
        } else if (washingMachineProgram == WashingMachinePrograms.Intense) {
            timer = 72000;
        } else if (washingMachineProgram == WashingMachinePrograms.Quick) {
            timer = 36000;
        } else if (washingMachineProgram == WashingMachinePrograms.Spin) {
            timer = 10000;
        }
    }

    public void startWashing() {
        if (washingMachineProgram.equals(WashingMachinePrograms.notSet) || degree == -1) {
            System.out.println("you must set a program and a degree");
        } else {
            start = System.currentTimeMillis();
            washingMachineThreadBehaviour = new WashingMachineThread(timer, this);
            washingThread = new Thread(washingMachineThreadBehaviour, "washingMachineThread");
            washingThread.start();
            deviceState = DeviceStates.Running;
        }
    }

    public void checkTimer() {
        if (deviceState == DeviceStates.Running) {
            long remainingTimeSec = (timer - (System.currentTimeMillis() - start)) / 1000;
            if (remainingTimeSec <= 0) {
                System.out.println("No time ramining, the program is finished");
            } else {
                int remaining = (int) remainingTimeSec;
                System.out.println("Remaining time: " + remaining);
            }
        } else if (deviceState == DeviceStates.On || deviceState == DeviceStates.Ended) {
            if (timer == -1) {
                System.out.println("You did not set a program yet");
            } else {
                int timerInSec = (int) (timer / 1000);
                System.out.println("Set time: " + timerInSec);
            }
        }
    }

    public void switchOff() {
        degree = -1;
        timer = -1;
        deviceState = DeviceStates.Off;
        washingMachineProgram = WashingMachinePrograms.notSet;
        start = 0;
    }

    public void interrupt() {
        if (deviceState == DeviceStates.Running) {
            washingMachineThreadBehaviour.stop();
            washingThread = null;
            timer = -1;
            degree = -1;
            deviceState = DeviceStates.On;
            washingMachineProgram = WashingMachinePrograms.notSet;
            start = 0;
        }
    }

}
