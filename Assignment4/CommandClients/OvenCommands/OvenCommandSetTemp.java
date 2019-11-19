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
            System.out.print("enter degrees (max 300): ");
            String input = scannerTemp.next();
            try {
                inputTemp = Integer.parseInt(input);
                if (inputTemp <= 300 && inputTemp >= 0)
                    break;
                else {
                    System.out.println("must be less than 300 and at least 0 degrees");
                }
            } catch (NumberFormatException ne) {
                System.out.println("must be a number");
            }
        }
        oven.setTemperature(inputTemp);
    }
}
