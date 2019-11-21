package CommandClients.MicrowaveCommands;

import CommandClients.Command;
import ReceiverDevices.Microwave;

public class MicrowaveCommandOn implements Command {
    private Microwave microwave;
    private String commandName = Microwave.DeviceCommands.SwitchOn.name();

    public MicrowaveCommandOn(Microwave microwave) {
        this.microwave = microwave;
    }

    public String getCommandName() {
        return commandName;
    }

    public void execute() {
        microwave.switchOn();
    }

}
