package CommandHandler;

import CommandClients.Command;
import CommandClients.NoCommand;
import CommandClients.OvenCommands.*;
import ReceiverDevices.Oven;

import java.util.ArrayList;

public class CleaningRobotCommandHandler implements CommandHandler{
    private int nrOfCommands = 8;
    private Command[] buttonSlots = new Command[nrOfCommands];

    private CleaningRobot robot;

    public CleaingRobotCommandHandler(CleaningRobot robot) {
        this.robot = robot;
        for (int i = 0; i < nrOfCommands; i++) {
            buttonSlots[0] = new NoCommand();
        }
    }

    public void configButtons() {
        //must follow the order of the Program enum in the device
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
