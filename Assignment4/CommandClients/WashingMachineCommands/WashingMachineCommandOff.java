package CommandClients.WashingMachineCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;
import ReceiverDevices.WashingMachine;

public class WashingMachineCommandOff implements Command {
    private String commandName = WashingMachine.DeviceCommands.SwitchOff.name();
    private WashingMachine washingMachine;


    public WashingMachineCommandOff(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    @Override
    public void execute() {
        washingMachine.SwitchOff();
    }

    @Override
    public String getCommandName() {
        return commandName;
    }
}
