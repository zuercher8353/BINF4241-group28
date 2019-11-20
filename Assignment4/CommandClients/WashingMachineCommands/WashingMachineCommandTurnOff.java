package CommandClients.WashingMachineCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;
import ReceiverDevices.WashingMachine;

public class WashingMachineCommandTurnOff implements Command {
    private WashingMachine washingMachine;
    private String commandName = WashingMachine.DeviceCommands.Interrupt.name();

    public WashingMachineCommandTurnOff(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    @Override
    public void execute() {
        washingMachine.interrupt();
    }

    @Override
    public String getCommandName() {
        return commandName;
    }
}
