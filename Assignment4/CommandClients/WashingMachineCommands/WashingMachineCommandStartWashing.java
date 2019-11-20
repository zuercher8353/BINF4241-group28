package CommandClients.WashingMachineCommands;
import CommandClients.Command;
import ReceiverDevices.Oven;
import ReceiverDevices.WashingMachine;

public class WashingMachineCommandStartWashing implements Command {
    private WashingMachine washingMachine;
    private String commandName = WashingMachine.DeviceCommands.StartWashing.name();

    public WashingMachineCommandStartWashing(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
        washingMachine.startWashing();
    }
}
