package CommandClients.OvenCommands;
import CommandClients.Command;
import ReceiverDevices.*;

public class OvenCommandOn implements Command {

    private Oven oven;

    public OvenCommandOn(Oven oven) {
        this.oven = oven;
    }

    @Override
    public void execute() {
        oven.turnOn();
    }
}
