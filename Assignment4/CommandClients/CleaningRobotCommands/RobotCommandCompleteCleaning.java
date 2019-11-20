package CommandClients.CleaningRobotCommands;

import CommandClients.Command;
import ReceiverDevices.CleaningRobot;

public class RobotCommandCompleteCleaning implements Command {
    private CleaningRobot robot;
    private String commandName = CleaningRobot.DeviceCommands.CompleteOutstandingCleaning.name();

    public RobotCommandCompleteCleaning(CleaningRobot robot) {
        this.robot = robot;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
        robot.startCleaner();
    }
}
