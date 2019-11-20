package CommandClients.OvenCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;

public class OvenCommandCheckTimer implements Command {

    private Oven oven;
    private String commandName = "CheckTimer";

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
