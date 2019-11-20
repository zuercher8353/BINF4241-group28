package CommandClients.WashingMachineCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;
import ReceiverDevices.WashingMachine;

public class WashingMachineCommandCheckTimer implements Command {

    private WashingMachine washingMachine;
    private String commandName = WashingMachine.DeviceCommands.CheckTimer.name();

    public WashingMachineCommandCheckTimer(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    @Override
    public void execute() {
        washingMachine.checkTimer();
    }

    @Override
    public String getCommandName() {
        return commandName;
    }
}

