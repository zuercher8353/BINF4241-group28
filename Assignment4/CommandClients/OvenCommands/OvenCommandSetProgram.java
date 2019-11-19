package CommandClients.OvenCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;

public class OvenCommandSetProgram implements Command {

    private Oven oven;
    private String commandName = "SetProgram";

    public OvenCommandSetProgram(Oven oven) {
        this.oven = oven;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {

        for(Enum Ovenprogram : oven.OvenProgram)
    }
}
