package CommandClients.WashingMachineCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;
import ReceiverDevices.WashingMachine;

public class WashingMachineCommandOff implements Command {
    private WashingMachine washingMachine;
    private String commandName = WashingMachine.DeviceCommands.SwitchOff.name();

    public WashingMachineCommandOff(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    @Override
    public void execute() {
    }

    @Override
    public String getCommandName() {
        return commandName;
    }
}
