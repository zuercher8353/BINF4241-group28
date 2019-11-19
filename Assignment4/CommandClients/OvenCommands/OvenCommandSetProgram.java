package CommandClients.OvenCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;

import java.util.Scanner;

public class OvenCommandSetProgram implements Command {

    private Oven oven;
    private String commandName = "SetUpProgram";

    public OvenCommandSetProgram(Oven oven) {
        this.oven = oven;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {

        //print Program Menu
        for (Enum Ovenprogram : Oven.OvenProgram.values()) {
            if (!Ovenprogram.name().equals("notSet")) {
                System.out.println(Ovenprogram.name());
            }
        }
        System.out.println("back");

        Scanner scannerTemp = new Scanner(System.in);
        String inputProgram = "";
        boolean programSet = false;
        //validate Input
        while ((!inputProgram.equals("back") && !programSet)) {
            System.out.print("Enter Program: ");
            inputProgram = scannerTemp.next();
            try {
                for (Enum Ovenprogram : Oven.OvenProgram.values()) {
                    if (Ovenprogram.name().equals(inputProgram)) {
                        oven.setUpProgram(Ovenprogram.name());
                        programSet = true;
                        break;
                    }
                }
                //System.out.println("Program not available");
            } catch (NumberFormatException ne) { //add another exeption
                System.out.println("Error");
            }
        }
    }
}
