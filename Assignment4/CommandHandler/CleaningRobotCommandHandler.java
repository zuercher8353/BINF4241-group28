package CommandHandler;

import CommandClients.CleaningRobotCommands.*;
import CommandClients.Command;
import CommandClients.NoCommand;
import ReceiverDevices.*;

import java.util.ArrayList;

public class CleaningRobotCommandHandler implements CommandHandler{
    private int nrOfCommands = CleaningRobot.DeviceCommands.values().length;
    private Command[] buttonSlots = new Command[nrOfCommands];


    private CleaningRobot robot;

    public CleaningRobotCommandHandler(CleaningRobot robot) {
        this.robot = robot;
        for (int i = 0; i < nrOfCommands; i++) {
            buttonSlots[0] = new NoCommand();
        }
    }

    public void configButtons() {
        //must follow the order of the Program enum in the device
        buttonSlots[0] = new RobotCommandChargingStatus(robot);
        buttonSlots[1] = new RobotCommandCheckBatteryStatus(robot);
        buttonSlots[2] = new RobotCommandCheckCleaningPercentage(robot);
        buttonSlots[3] = new RobotCommandCompleteCleaning(robot);
        buttonSlots[4] = new RobotCommandEndCleaning(robot);
        buttonSlots[5] = new RobotCommandSetTimer(robot);
        buttonSlots[6] = new RobotCommandStartCleaner(robot);
    }

    public boolean validateCommand(String userInput) {
        ArrayList stateCommands = robot.getStateCommands();
        for (Object stateCommand : stateCommands) {
            if (stateCommand.equals(userInput)) {
                return true;
            }
        }
        return false;
    }

    public void handleCommand(String userInput) {
        int i = 0;
        ArrayList stateCommands = robot.getStateCommands();
        for (Command buttonSlot : buttonSlots) {
            if (buttonSlot.getCommandName().equals(userInput)) {
                buttonSlots[i].execute();
            }
            i++;
        }
    }

        public void printCommandMenu(){
        System.out.println("----------");
        ArrayList stateCommands = robot.getStateCommands();
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
