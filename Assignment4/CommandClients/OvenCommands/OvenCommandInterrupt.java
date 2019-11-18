package CommandClients.OvenCommands;

import CommandClients.Command;
import CommandHandler.CommandHandler;
import ReceiverDevices.Oven;

public class OvenCommandInterrupt implements Command {
    private Oven oven;
    private String commandName = "Interrupt";

    public OvenCommandInterrupt(Oven oven) {
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
