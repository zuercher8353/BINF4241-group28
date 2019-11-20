package CommandClients.CleaningRobotCommands;

import CommandClients.Command;
import ReceiverDevices.CleaningRobot;

public class RobotCommandCheckCleaningPercentage implements Command {
    private CleaningRobot robot;
    private String commandName = CleaningRobot.DeviceCommands.CheckCleaningCompletion.name();

    public RobotCommandCheckCleaningPercentage(CleaningRobot robot) {
        this.robot = robot;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
        robot.checkPercentageOfCleaningCompletion();
    }
}
