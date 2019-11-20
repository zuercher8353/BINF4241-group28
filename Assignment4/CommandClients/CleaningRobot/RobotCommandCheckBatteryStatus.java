package CommandClients.CleaningRobot;

import CommandClients.Command;
import ReceiverDevices.CleaningRobot;

public class RobotCommandCheckBatteryStatus implements Command {
    private CleaningRobot robot;
    private String commandName = "CheckBatteryStatus";

    public RobotCommandCheckBatteryStatus(CleaningRobot robot) {
        this.robot = robot;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
        robot.checkBatteryStatus();
    }
}
