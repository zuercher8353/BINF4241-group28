package CommandClients.OvenCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;

import java.util.Scanner;

public class OvenCommandSetTemp implements Command {
    private Oven oven;
    private String commandName = "SetTemperature";

    public OvenCommandSetTemp(Oven oven) {
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
