package CommandClients.DishwasherCommands;

import CommandClients.Command;
import ReceiverDevices.Dishwasher;
import ReceiverDevices.WashingMachine;

public class DishwasherCommandOff implements Command {
    private String commandName = Dishwasher.DeviceCommands.SwitchOff.name();
    private Dishwasher dishwasher;


    public DishwasherCommandOff(Dishwasher dishwasher) {
        this.dishwasher = dishwasher;
    }

    @Override
    public void execute() {
        dishwasher.switchOff();
    }

    @Override
    public String getCommandName() {
        return commandName;
    }
}
