package CommandClients.CleaningRobot;

import CommandClients.Command;
import CommandHandler.CommandHandler;
import ReceiverDevices.CleaningRobot;
import ReceiverDevices.Oven;

public class RobotCommandChargingStatus implements Command {
    private CleaningRobot robot;
    private String commandName = "CheckChargingStatus";

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
