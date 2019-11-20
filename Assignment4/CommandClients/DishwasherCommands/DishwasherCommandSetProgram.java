package CommandClients.DishwasherCommands;

import CommandClients.Command;
import ReceiverDevices.Dishwasher;
import ReceiverDevices.WashingMachine;

public class DishwasherCommandSetProgram implements Command {
    private Dishwasher dishwasher;
    private String commandName = "SetProgram";

    public DishwasherCommandSetProgram(Dishwasher dishwasher) {
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
