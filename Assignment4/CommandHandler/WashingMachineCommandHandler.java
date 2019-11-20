package CommandHandler;

import CommandClients.Command;
import CommandClients.NoCommand;
import CommandClients.WashingMachineCommands.*;
import ReceiverDevices.WashingMachine;


public class WashingMachineCommandHandler implements CommandHandler{

    private WashingMachine washingMachine;
    private int nrOfCommands = WashingMachine.DeviceCommands.values().length;
    private Command[] buttonSlots = new Command[nrOfCommands];




    public WashingMachineCommandHandler(WashingMachine washingMachine){
        this.washingMachine = washingMachine;
        for(int i = 0; i < nrOfCommands; i++) {
            buttonSlots[0] = new NoCommand();
        }
    }

    public void configButtons() {
        buttonSlots[0] = new WashingMachineCommandOn(washingMachine);
        buttonSlots[1] = new WashingMachineCommandOn(washingMachine);
        buttonSlots[2] = new WashingMachineCommandOn(washingMachine);
        buttonSlots[3] = new WashingMachineCommandOn(washingMachine);
        buttonSlots[4] = new WashingMachineCommandOn(washingMachine);
        buttonSlots[5] = new WashingMachineCommandOn(washingMachine);
        buttonSlots[6] = new WashingMachineCommandOn(washingMachine);
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
