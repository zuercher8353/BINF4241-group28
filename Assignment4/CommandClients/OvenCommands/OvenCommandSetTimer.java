package CommandClients.OvenCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;

public class OvenCommandSetTimer implements Command {
    private Oven oven;

    public OvenCommandSetTimer(Oven oven) {
        this.oven = oven;
    }

    @Override
    public void execute() {
    }
}
