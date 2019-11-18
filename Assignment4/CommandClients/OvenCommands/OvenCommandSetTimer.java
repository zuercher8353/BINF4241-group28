package CommandClients.OvenCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;

public class OvenCommandSetTimer implements Command {
    private Oven oven;
    private String commandName = "SetTimer";

    public OvenCommandSetTimer(Oven oven) {
        this.oven = oven;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
    }


}
