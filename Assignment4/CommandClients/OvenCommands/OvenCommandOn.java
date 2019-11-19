package CommandClients.OvenCommands;
import CommandClients.Command;
import ReceiverDevices.*;

public class OvenCommandOn implements Command {

    private Oven oven;
    private String commandName = "SwitchOn";

    public OvenCommandOn(Oven oven) {
        this.oven = oven;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
        oven.SwitchOn();
    }


}
