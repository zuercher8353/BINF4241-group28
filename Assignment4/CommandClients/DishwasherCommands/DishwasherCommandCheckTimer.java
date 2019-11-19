package CommandClients.DishwasherCommands;

import CommandClients.Command;
import ReceiverDevices.Dishwasher;
import ReceiverDevices.WashingMachine;

public class DishwasherCommandCheckTimer implements Command {

    private Dishwasher dishwasher;
    private String commandName = "CheckTimer";

    public DishwasherCommandCheckTimer(Dishwasher dishwasher) {
        this.dishwasher = dishwasher;
    }

    @Override
    public void execute() {
    }

    @Override
    public String getCommandName() {
        return null;
    }
}

