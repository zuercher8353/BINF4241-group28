package CommandClients.OvenCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;

public class OvenCommandSetProgram implements Command {
    private Oven oven;

    public OvenCommandSetProgram(Oven oven) {
        this.oven = oven;
    }

    @Override
    public void execute() {
    }
}
