package CommandClients.OvenCommands;

import CommandClients.Command;
import CommandHandler.CommandHandler;
import ReceiverDevices.Oven;

public class OvenCommandInterrupt implements Command {
    private Oven oven;

    public OvenCommandInterrupt(Oven oven) {
        this.oven = oven;
    }

    @Override
    public void execute() {
    }
}
