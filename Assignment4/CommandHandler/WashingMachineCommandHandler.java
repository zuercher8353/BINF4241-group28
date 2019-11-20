package CommandHandler;

import CommandClients.Command;
import CommandClients.NoCommand;
import CommandClients.WashingMachineCommands.*;
import ReceiverDevices.WashingMachine;

import java.util.ArrayList;


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

    public void setCommands() {
        buttonSlots[0] = new WashingMachineCommandOn(washingMachine);
        buttonSlots[1] = new WashingMachineCommandCheckTimer(washingMachine);
        buttonSlots[2] = new WashingMachineCommandSetDegree(washingMachine);
        buttonSlots[3] = new WashingMachineCommandSetProgram(washingMachine);
        buttonSlots[4] = new WashingMachineCommandTurnOff(washingMachine);
        buttonSlots[4] = new WashingMachineCommandOff(washingMachine);
    }

    public boolean validateCommand(String userInput) {
        ArrayList stateCommands = washingMachine.getStateCommands();
        for (Object stateCommand : stateCommands) {
            if (stateCommand.equals(userInput)) {
                return true;
            }
        }
        return false;
    }

    public void handleCommand(String userInput) {
        int i = 0;
        for (Command buttonSlot : buttonSlots) {
            if (buttonSlot.getCommandName().equals(userInput)) {
                buttonSlots[i].execute();
            }
            i++;
        }
    }

    public void printCommandMenu(){
        System.out.println("----------");

        ArrayList stateCommands = washingMachine.getStateCommands();
        for (Object stateCommand : stateCommands) {
            int iter = 0;
            int buttonNumber = -1;
            for(Command buttonSlot : buttonSlots) {
                if (buttonSlots[iter].getCommandName().equals(stateCommand)) {
                    buttonNumber = iter;
                }

                iter++;
            }
            //System.out.println("[" +buttonNumber+ "]"+stateCommand);
            System.out.println(stateCommand);
        }

        System.out.println("back");
        System.out.println("----------");
    }
}
