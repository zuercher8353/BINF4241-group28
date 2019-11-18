package CommandClients.OvenCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;

public class OvenCommandSetTemp implements Command {
    private Oven oven;

    public OvenCommandSetTemp(Oven oven) {
        this.oven = oven;
    }

    @Override
    public void execute() {
    }
}
