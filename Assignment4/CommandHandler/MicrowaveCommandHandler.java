package CommandHandler;

import CommandClients.Command;
import CommandClients.NoCommand;
import ReceiverDevices.Microwave;

public class MicrowaveCommandHandler {
    private Command[] buttonSlots = new Command[DeviceCommands.values().length];
    private Microwave microwave;

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

    public MicrowaveCommandHandler(Microwave microwave){
        this.microwave = microwave;
        for(int i = 0; i < DeviceCommands.values().length; i++) {
            buttonSlots[i] = new NoCommand();
        }
    }

    public void configButtons() {

    }

    public boolean validateCommand(String userInput) {
        int i = 0;
        for (DeviceCommands command : DeviceCommands.values()) {
            if (command.name().equals(userInput)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void handleCommand(String userInput) {
        int i = 0;
        for (DeviceCommands command : DeviceCommands.values()) {
            if (command.name().equals(userInput)) {
                buttonSlots[i].execute();
            }
            i++;
        }
    }

    public void printCommandMenu(){
        System.out.println("----------");
        int i = 0;
        for (DeviceCommands commands : DeviceCommands.values()) {
            System.out.println("["+i+"] "+commands);
            i++;
        }
        System.out.println("back");
        System.out.println("----------");
    }
}
