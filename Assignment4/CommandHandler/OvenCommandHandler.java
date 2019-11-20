package CommandHandler;

import CommandClients.*;
import CommandClients.OvenCommands.*;
import ReceiverDevices.*;

import java.util.ArrayList;

public class OvenCommandHandler implements CommandHandler {

    private int nrOfCommands = Oven.DeviceCommands.values().length;
    private Command[] buttonSlots = new Command[nrOfCommands];

    private Oven oven;

    public OvenCommandHandler(Oven oven) {
        this.oven = oven;
        for (int i = 0; i < nrOfCommands; i++) {
            buttonSlots[0] = new NoCommand();
        }
    }

    public void setCommands() {
        //must follow the order of the Program enum in the device
        //setCommand
        buttonSlots[0] = new OvenCommandOn(oven);
        buttonSlots[1] = new OvenCommandOff(oven);
        buttonSlots[2] = new OvenCommandSetTimer(oven);
        buttonSlots[3] = new OvenCommandSetTemp(oven);
        buttonSlots[4] = new OvenCommandSetProgram(oven);
        buttonSlots[5] = new OvenCommandStartCooking(oven);
        buttonSlots[6] = new OvenCommandCheckTimer(oven);
        buttonSlots[7] = new OvenCommandInterrupt(oven);
    }

    public boolean validateCommand(String userInput) {
        ArrayList stateCommands = oven.getStateCommands();
        for (Object stateCommand : stateCommands) {
            if (stateCommand.equals(userInput)) {
                return true;
            }
        }
        return false;
    }

    public void handleCommand(String userInput) {
        int i = 0;
        ArrayList stateCommands = oven.getStateCommands();
        for (Command buttonSlot : buttonSlots) {
            if (buttonSlot.getCommandName().equals(userInput)) {
                buttonSlots[i].execute();
            }
            i++;
        }
    }

    public void printCommandMenu(){
        System.out.println("----------");

        ArrayList stateCommands = oven.getStateCommands();
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
