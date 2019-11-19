package CommandClients.OvenCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;

public class OvenCommandSetProgram implements Command {

    private Oven oven;
    private String commandName = "SetUpProgram";

    public OvenCommandSetProgram(Oven oven) {
        this.oven = oven;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
        for(Enum Ovenprogram : Oven.OvenProgram.values()){
            System.out.println(Ovenprogram.name());
        }
    }
}
