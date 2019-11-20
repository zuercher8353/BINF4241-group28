package CommandClients.OvenCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;

import java.util.Scanner;

public class OvenCommandSetTimer implements Command {
    private Oven oven;
    private String commandName = "SetTimer";

    public OvenCommandSetTimer(Oven oven) {
        this.oven = oven;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
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
        oven.SetTimer(inputTime);
    }


}
