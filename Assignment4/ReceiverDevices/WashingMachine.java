package ReceiverDevices;

import Threads.WashingMachineThread;

import java.util.ArrayList;

public class WashingMachine implements Devices, WashingDevices {
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
        TurnOff
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
            possibleFunctions.add(DeviceCommands.TurnOff.name());
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
        washingMachineThreadBehaviour.stop();
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
        start = System.currentTimeMillis();
        deviceState = DeviceStates.Running;
        washingMachineThreadBehaviour = new WashingMachineThread(timer, this);
        washingThread = new Thread(washingMachineThreadBehaviour, "washingMachineThread");
        washingThread.start();
    }

    public void checkTimer() {
        if (deviceState == DeviceStates.Running) {
            float remainingTimeSec = (float) (timer - (System.currentTimeMillis() - start)) / 1000;
            remainingTimeSec = Math.max(0, remainingTimeSec);
            System.out.println("Remaining time: " + remainingTimeSec);
            }

        else if (deviceState == DeviceStates.On || deviceState == DeviceStates.Ended) {
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
