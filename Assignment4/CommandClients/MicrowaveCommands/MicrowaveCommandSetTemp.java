package CommandClients.MicrowaveCommands;
import CommandClients.Command;
import ReceiverDevices.Microwave;

import java.util.Scanner;

public class MicrowaveCommandSetTemp implements Command {
    private Microwave microwave;
    private String commandName = Microwave.DeviceCommands.SetTemperature.name();

    public MicrowaveCommandSetTemp(Microwave microwave) {
        this.microwave = microwave;
    }

    public String getCommandName() {
        return commandName;
    }

    public void execute() {
        Scanner scannerTemp = new Scanner(System.in);
        int inputTemp = -1;
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
        microwave.setTemperature(inputTemp);
    }
}
