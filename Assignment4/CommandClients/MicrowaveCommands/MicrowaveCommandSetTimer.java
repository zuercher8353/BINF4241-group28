package CommandClients.MicrowaveCommands;

import CommandClients.Command;
import ReceiverDevices.Microwave;

import java.util.Scanner;

public class MicrowaveCommandSetTimer implements Command {
    private Microwave microwave;
    private String commandName = Microwave.DeviceCommands.SetTimer.name();

    public MicrowaveCommandSetTimer(Microwave microwave) {
        this.microwave = microwave;
    }

    public String getCommandName() {
        return commandName;
    }

    public void execute() {
        Scanner scannerTime = new Scanner(System.in);
        int inputTime = -1;
        while (true) {
            System.out.print("enter timer (in sec.): ");
            String input = scannerTime.next();
            try {
                inputTime = Integer.parseInt(input);
                if (inputTime >= 0)
                    break;
                else {
                    System.out.println("time must be > 0");
                }
            } catch (NumberFormatException ne) {
                System.out.println("must be a number");
            }
        }
        microwave.setTimer(inputTime);
    }
}
