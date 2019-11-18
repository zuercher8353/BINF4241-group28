package CommandClients.OvenCommands;
import CommandClients.Command;
import ReceiverDevices.Oven;

public class OvenCommandStartCooking implements Command {
    private Oven oven;

    public OvenCommandStartCooking(Oven oven) {
        this.oven = oven;
    }

    @Override
    public void execute() {
    }
}
