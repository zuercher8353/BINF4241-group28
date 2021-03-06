package CommandClients.CleaningRobotCommands;

import CommandClients.Command;
import ReceiverDevices.CleaningRobot;

public class RobotCommandStartCleaner implements Command {
    private CleaningRobot robot;
    private String commandName = CleaningRobot.DeviceCommands.StartCleaner.name();

    public RobotCommandStartCleaner(CleaningRobot robot) {
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
