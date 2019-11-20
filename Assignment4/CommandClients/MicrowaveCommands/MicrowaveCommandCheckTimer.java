package CommandClients.MicrowaveCommands;

import CommandClients.Command;
import ReceiverDevices.Microwave;

public class MicrowaveCommandCheckTimer implements Command {
    private Microwave microwave;
    private String commandName = Microwave.DeviceCommands.CheckTimer.name();

    public MicrowaveCommandCheckTimer(Microwave microwave) {
        this.microwave = microwave;
    }

    public String getCommandName() {
        return commandName;
    }

    public void execute() {
        microwave.checkTimer();
    }
}
