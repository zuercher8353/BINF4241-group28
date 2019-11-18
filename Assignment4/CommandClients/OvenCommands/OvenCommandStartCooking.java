package CommandClients.OvenCommands;
import CommandClients.Command;
import ReceiverDevices.Oven;

public class OvenCommandStartCooking implements Command {
    private Oven oven;
    private String commandName = "StartCooking";

    public OvenCommandStartCooking(Oven oven) {
        this.oven = oven;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
    }


}
