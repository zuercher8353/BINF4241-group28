package ReceiverDevices;


public class Oven implements Device {
    private long timer = -1;
    private int temperature = -1;
    private DeviceStates deviceState = DeviceStates.Off;
    private OvenProgram ovenProgram = OvenProgram.notSet;
    private long start;



    private enum DeviceStates {
        On,
        Off,
        Running
    }


    private enum OvenProgram {
        ventilated,
        grill,
        defrost,
        notSet
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

    public DeviceStates getDeviceState() {
        return deviceState;
    }

    public void SwitchOn() {
        if (deviceState == DeviceStates.Off){
            deviceState = DeviceStates.On;
        }
        else{
            System.out.println("Device is already Switched on");
        }
    }
    public void SetTimer(int time){
        if(deviceState == DeviceStates.On ){
            timer =  time * 1000;
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
    public void setUpProgram (OvenProgram ovenProgram){
        if(deviceState == DeviceStates.On ){
            ovenProgram = ovenProgram;
        }
        else if(deviceState == DeviceStates.Off){
            System.out.println("You need to switch the oven on before you set a program");
        }
        else if(deviceState == DeviceStates.Running){
            System.out.println("The oven is running you cant set a program");
        }


    }
    public void StartCooking(){
        if(deviceState == DeviceStates.On ){
            if(temperature != -1 && timer != -1 && ovenProgram != OvenProgram.notSet ){
                start =  System.currentTimeMillis();
                deviceState = DeviceStates.Running;
            }
            else{
                System.out.println("Not all parameters are set you can`t start cooking");
            }
        }
        else if(deviceState == DeviceStates.Off){
            System.out.println("You need to switch the oven on before you can start cooking");
        }
        else if(deviceState == DeviceStates.Running){
            System.out.println("The oven is already cooking");
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
            }
        }
        else if(deviceState == DeviceStates.Off){
            System.out.println("You need to switch the oven, to check the timer");
        }
        else if(deviceState == DeviceStates.On ){
            if(timer == -1){
                System.out.println("You did not set a timer yet");
            }
            else{
                int timerInSec = (int) (timer/1000);
            }
        }

    }


    public void interrupt(){
        if(deviceState == DeviceStates.Running) {
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
    public void SwitchOff() {
        timer = -1;
        temperature = -1;
        deviceState = DeviceStates.Off;
        ovenProgram = OvenProgram.notSet;
        start = 0;
    }


    public void printDeviceMenu(){
        for (DeviceCommands commands : DeviceCommands.values()) {
            System.out.println(commands);
        }
    }



}
