package CommandClients.OvenCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;

public class OvenCommandCheckTimer implements Command {

    private Oven oven;

    public OvenCommandCheckTimer(Oven oven) {
        this.oven = oven;
    }

    @Override
    public void execute() {
    }
}

