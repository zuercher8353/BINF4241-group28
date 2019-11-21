package CommandClients.MicrowaveCommands;

import CommandClients.Command;
import ReceiverDevices.Microwave;

public class MicrowaveCommandStartBaking implements Command {
    private Microwave microwave;
    private String commandName = Microwave.DeviceCommands.StartBaking.name();

    public MicrowaveCommandStartBaking(Microwave microwave) {
        this.microwave = microwave;
    }

    public String getCommandName() {
        return commandName;
    }

    public void execute() {
        microwave.startBaking();
    }
}
