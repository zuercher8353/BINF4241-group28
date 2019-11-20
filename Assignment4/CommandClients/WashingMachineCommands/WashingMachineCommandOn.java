package CommandClients.WashingMachineCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;
import ReceiverDevices.WashingMachine;

public class WashingMachineCommandOn implements Command {

    private WashingMachine washingMachine;
    private String commandName = WashingMachine.DeviceCommands.SwitchOff.name();

    public WashingMachineCommandOn(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    @Override
    public void execute() {
        washingMachine.switchOn();
    }

    @Override
    public String getCommandName() {
        return commandName;
    }
}
