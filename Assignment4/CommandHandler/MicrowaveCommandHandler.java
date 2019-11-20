package CommandHandler;
import CommandClients.*;
import CommandClients.MicrowaveCommands.*;
import ReceiverDevices.Microwave;

import java.util.ArrayList;

public class MicrowaveCommandHandler implements CommandHandler {

    private int nrOfCommands = Microwave.DeviceCommands.values().length;
    private Command[] buttonSlots = new Command[nrOfCommands];

    private Microwave microwave;

    public MicrowaveCommandHandler(Microwave microwave) {
        this.microwave = microwave;
        for (int i = 0; i < nrOfCommands; i++) {
            buttonSlots[0] = new NoCommand();
        }
    }

    public void setCommands() {
        //must follow the order of the Program enum in the device
        //setCommand
        buttonSlots[0] = new MicrowaveCommandOn(microwave);
        buttonSlots[1] = new MicrowaveCommandOff(microwave);
        buttonSlots[2] = new MicrowaveCommandSetTimer(microwave);
        buttonSlots[3] = new MicrowaveCommandSetTemp(microwave);
        buttonSlots[4] = new MicrowaveCommandStartBaking(microwave);
        buttonSlots[5] = new MicrowaveCommandCheckTimer(microwave);
        buttonSlots[6] = new MicrowaveCommandInterrupt(microwave);
    }

    public boolean validateCommand(String userInput) {
        ArrayList stateCommands = microwave.getStateCommands();
        for (Object stateCommand : stateCommands) {
            if (stateCommand.equals(userInput)) {
                return true;
            }
        }
        return false;
    }

    public void handleCommand(String userInput) {
        int i = 0;
        ArrayList stateCommands = microwave.getStateCommands();
        for (Command buttonSlot : buttonSlots) {
            if (buttonSlot.getCommandName().equals(userInput)) {
                buttonSlots[i].execute();
            }
            i++;
        }
    }

    public void printCommandMenu(){
        System.out.println("----------");

        ArrayList stateCommands = microwave.getStateCommands();
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
