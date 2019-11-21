package CommandClients.MicrowaveCommands;

import CommandClients.Command;
import CommandHandler.CommandHandler;
import ReceiverDevices.Oven;

import ReceiverDevices.Microwave;

public class MicrowaveCommandInterrupt implements Command {
    private Microwave microwave;
    private String commandName = Microwave.DeviceCommands.Interrupt.name();

    public MicrowaveCommandInterrupt(Microwave microwave) {
        this.microwave = microwave;
    }

    public String getCommandName() {
        return commandName;
    }

    public void execute() {
        microwave.interrupt();
    }
}
