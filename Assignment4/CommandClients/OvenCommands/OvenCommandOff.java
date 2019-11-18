package CommandClients.OvenCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;

public class OvenCommandOff implements Command {
    private Oven oven;

    public OvenCommandOff(Oven oven) {
        this.oven = oven;
    }

    @Override
    public void execute() {
    }
}
