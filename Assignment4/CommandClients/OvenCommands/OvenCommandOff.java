package CommandClients.OvenCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;

public class OvenCommandOff implements Command {

    private String commandName = "SwitchOff";
    private Oven oven;

    public OvenCommandOff(Oven oven) {
        this.oven = oven;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
        oven.switchOff();
    }
}
