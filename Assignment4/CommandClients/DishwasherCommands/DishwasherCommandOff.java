package CommandClients.DishwasherCommands;

import CommandClients.Command;
import ReceiverDevices.Dishwasher;
import ReceiverDevices.WashingMachine;

public class DishwasherCommandOff implements Command {
    private Dishwasher dishwasher;


    public DishwasherCommandOff(Dishwasher dishwasher) {
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
