package CommandClients.MicrowaveCommands;

import CommandClients.Command;
import ReceiverDevices.Microwave;

public class MicrowaveCommandOff implements Command {
    private String commandName = Microwave.DeviceCommands.SwitchOff.name();
    private Microwave microwave;

    public MicrowaveCommandOff(Microwave microwave) {
        this.microwave = microwave;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
        microwave.switchOff();
    }
}
