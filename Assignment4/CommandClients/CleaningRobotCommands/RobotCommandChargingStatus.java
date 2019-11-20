package CommandClients.CleaningRobotCommands;

import CommandClients.Command;
import ReceiverDevices.CleaningRobot;

public class RobotCommandChargingStatus implements Command {
    private CleaningRobot robot;
    private String commandName = CleaningRobot.DeviceCommands.CheckBatteryChargingStatus.name();

    public RobotCommandChargingStatus(CleaningRobot robot) {
        this.robot = robot;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
        robot.checkBatteryChargingStatus();
    }

}
