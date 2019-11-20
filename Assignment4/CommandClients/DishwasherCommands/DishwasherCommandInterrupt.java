package CommandClients.DishwasherCommands;

import CommandClients.Command;
import ReceiverDevices.Dishwasher;
import ReceiverDevices.WashingMachine;

public class DishwasherCommandInterrupt implements Command {
    private Dishwasher dishwasher;
    private String commandName = "Interrupt";

    public DishwasherCommandInterrupt(Dishwasher dishwasher) {
        this.dishwasher = dishwasher;
    }

    @Override
    public void execute() {
    }

    @Override
    public String getCommandName() {
        return commandName;
    }
}
