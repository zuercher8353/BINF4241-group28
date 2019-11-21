package CommandClients.DishwasherCommands;

import CommandClients.Command;
import ReceiverDevices.Dishwasher;
import ReceiverDevices.WashingMachine;

public class DishwasherCommandCheckTimer implements Command {

    private Dishwasher dishwasher;
    private String commandName = Dishwasher.DeviceCommands.CheckTimer.name();

    public DishwasherCommandCheckTimer(Dishwasher dishwasher) {
        this.dishwasher = dishwasher;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
        dishwasher.checkTimer();
    }
}

