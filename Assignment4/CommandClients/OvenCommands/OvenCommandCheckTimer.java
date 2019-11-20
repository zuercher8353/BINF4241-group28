package CommandClients.OvenCommands;

import CommandClients.Command;
import ReceiverDevices.CleaningRobot;
import ReceiverDevices.Oven;

public class OvenCommandCheckTimer implements Command {

    private Oven oven;
    private String commandName = Oven.DeviceCommands.CheckTimer.name();

    public OvenCommandCheckTimer(Oven oven) {
        this.oven = oven;
    }

    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
        oven.checkTimer();
    }
}
