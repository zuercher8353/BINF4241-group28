package CommandClients.OvenCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;

import java.util.Scanner;

public class OvenCommandSetTemp implements Command {
    private Oven oven;
    private String commandName = "SetTemperature";

    public OvenCommandSetTemp(Oven oven) {
        this.oven = oven;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
        Scanner scannerTemp = new Scanner(System.in);
        int inputTemp = 0;
        while (true) {
            System.out.print("enter degrees: ");
            String input = scannerTemp.next();
            try {
                inputTemp = Integer.parseInt(input);
                break;
            } catch (NumberFormatException ne) {
                System.out.println("must be a number");
            }
        }
        oven.setTemperature(inputTemp);
    }
}
