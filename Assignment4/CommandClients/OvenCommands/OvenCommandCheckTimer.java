package CommandClients.OvenCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;

public class OvenCommandCheckTimer implements Command {

    private String commandName = "CheckTimer";
    private Oven oven;

    public OvenCommandCheckTimer(Oven oven) {
        this.oven = oven;
    }

    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
    }
}

