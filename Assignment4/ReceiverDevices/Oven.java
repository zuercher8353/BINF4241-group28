package ReceiverDevices;
import Threads .*;


import java.util.ArrayList;

public class Oven implements Device {
    private long timer = -1;
    private int temperature = -1;
    private DeviceStates deviceState = DeviceStates.Off;
    private OvenProgram ovenProgram = OvenProgram.notSet;
    private long start;
    private Thread ovenThread;
    OvenThread ovenThreadBehaviour;

    private enum DeviceStates {
        On,
        Off,
        Running,
        Ended
    }


    public enum OvenProgram {
        ventilated,
        grill,
        defrost,
        notSet
    }

    public enum DeviceCommands {
        SwitchOn,
        SwitchOff,
        SetTimer,
        SetTemperature,
        SetUpProgram,
        StartCooking,
        CheckTimer,
        Interrupt
    }

    public ArrayList getStateCommands() {
        ArrayList<String> possibleFunctions = new ArrayList<String>();
        if (deviceState == DeviceStates.Off){
            possibleFunctions.add(DeviceCommands.SwitchOn.name());
        }
        else if(deviceState == DeviceStates.On || deviceState == DeviceStates.Ended){
            possibleFunctions.add(DeviceCommands.SwitchOff.name());
            possibleFunctions.add(DeviceCommands.SetTemperature.name());
            possibleFunctions.add(DeviceCommands.CheckTimer.name());
            possibleFunctions.add(DeviceCommands.SetTimer.name());
            possibleFunctions.add(DeviceCommands.SetUpProgram.name());
            if(temperature != -1 && timer != -1 && ovenProgram != OvenProgram.notSet ){
                possibleFunctions.add(DeviceCommands.StartCooking.name());
            }

        } else if(deviceState == DeviceStates.Running){
            possibleFunctions.add(DeviceCommands.Interrupt.name());
            possibleFunctions.add(DeviceCommands.SwitchOff.name());
            possibleFunctions.add(DeviceCommands.CheckTimer.name());
        }

        return possibleFunctions;
    }

    public void setEnded(){
        ovenThread = null;
        deviceState = DeviceStates.Ended;
    }

    public void switchOn() {
        if (deviceState == DeviceStates.Off){
            deviceState = DeviceStates.On;
        }
        else{
            System.out.println("Device is already Switched on");
        }
    }

    public void SetTimer(int time){
        if(deviceState == DeviceStates.On ){
            timer = (long) time * 1000;
        }
        else if(deviceState == DeviceStates.Off){
            System.out.println("You need to switch the oven on before you set a timer");
        }
        else if(deviceState == DeviceStates.Running){
            System.out.println("The oven is running you cant set a timer");
        }
    }

    public void setTemperature(int temp){
        if(deviceState == DeviceStates.On ){
            temperature = temp;
        }
        else if(deviceState == DeviceStates.Off){
            System.out.println("You need to switch the oven on before you set a temperature");
        }
        else if(deviceState == DeviceStates.Running){
            System.out.println("The oven is running you cant set a temperature");
        }
    }

    public void setUpProgram (String inputProgram){


        for(OvenProgram ENUM_ovenProgram : OvenProgram.values()) {
            if(ENUM_ovenProgram.toString().equals(inputProgram)) {
                ovenProgram = ENUM_ovenProgram;
            }
        }

        if(deviceState == DeviceStates.Off){
            System.out.println("You need to switch the oven on before you set a program");
        }
        else if(deviceState == DeviceStates.Running){
            System.out.println("The oven is running you cant set a program");
        }
    }

    public void StartCooking(){

        if(temperature != -1 && timer != -1 && ovenProgram != OvenProgram.notSet ){
            start =  System.currentTimeMillis();
            deviceState = DeviceStates.Running;
            ovenThreadBehaviour = new OvenThread(timer, this);
            ovenThread = new Thread(ovenThreadBehaviour, "ovenMachineThread");
            ovenThread.start();
        }
        else{
            System.out.println("Not all parameters are set you can`t start cooking");
        }

        if(deviceState == DeviceStates.Off){
            System.out.println("You need to switch the oven on before you can start cooking");
        }

    }

    public void checkTimer(){                              //returns remaining time if program is running else it returns the last timer set
        if(deviceState == DeviceStates.Running){

            long remainingTimeSec = (timer - (System.currentTimeMillis() - start)) / 1000 ;
            if(remainingTimeSec <= 0){
                System.out.println("No time remaining, the program is finished");
            }
            else{
                int remaining = (int) remainingTimeSec;
                System.out.println("Remaining Time: " + remaining);
            }
        }
        else if(deviceState == DeviceStates.Off){
            System.out.println("You need to switch the oven, to check the timer");
        }
        else if(deviceState == DeviceStates.On || deviceState == DeviceStates.Ended ){
            if(timer == -1){
                System.out.println("You did not set a timer yet");
            }
            else{
                int timerInSec = (int) (timer/1000);
                System.out.println("Set Time: " + timerInSec);
            }
        }

    }

    public void interrupt(){
        if(deviceState == DeviceStates.Running) {
            ovenThreadBehaviour.stop();
            ovenThread = null;
            timer = -1;
            temperature = -1;
            deviceState = DeviceStates.On;
            ovenProgram = OvenProgram.notSet;
            start = 0;
        }
        else{
            System.out.println("The oven is not in operation, you can´t interrupt");
        }
    }

    //allowed to switch off if program still running?
    public void switchOff() {
        timer = -1;
        temperature = -1;
        deviceState = DeviceStates.Off;
        ovenProgram = OvenProgram.notSet;
        start = 0;
    }
}
