package CommandClients.DishwasherCommands;

import CommandClients.Command;
import ReceiverDevices.Dishwasher;
import ReceiverDevices.WashingMachine;

public class DishwasherCommandInterrupt implements Command {
    private Dishwasher dishwasher;
    private String commandName = Dishwasher.DeviceCommands.Stop.name();

    public DishwasherCommandInterrupt(Dishwasher dishwasher) {
        this.dishwasher = dishwasher;
    }

    @Override
    public void execute() {
        dishwasher.interrupt();
    }

    @Override
    public String getCommandName() {
        return commandName;
    }
}
