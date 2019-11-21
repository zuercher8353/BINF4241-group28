package CommandClients.DishwasherCommands;

import CommandClients.Command;
import ReceiverDevices.Dishwasher;
import ReceiverDevices.WashingMachine;

import java.util.Scanner;

public class DishwasherCommandSetProgram implements Command {
    private Dishwasher dishwasher;
    private String commandName = Dishwasher.DeviceCommands.SetUpProgram.name();

    public DishwasherCommandSetProgram(Dishwasher dishwasher) {
        this.dishwasher = dishwasher;
    }

    @Override
    public void execute() {
        //print Program Menu without notSet
        System.out.println("---------");
        for (Enum DishwasherPrograms : Dishwasher.DishwasherPrograms.values()) {
            if (!DishwasherPrograms.name().equals("notSet")) {
                System.out.println(DishwasherPrograms.name());
            }
        }
        System.out.println("back");
        System.out.println("---------");

        Scanner scannerTemp = new Scanner(System.in);
        String inputProgram = "";
        boolean programSet = false;

        //validate Input
        while ((!inputProgram.equals("back") && !programSet)) {
            System.out.print("Enter Program: ");
            inputProgram = scannerTemp.next();
            try {
                for (Enum DishwasherPrograms : Dishwasher.DishwasherPrograms.values()) {
                    if (DishwasherPrograms.name().equals(inputProgram)) {
                        dishwasher.setUpProgram(DishwasherPrograms.name());
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

    @Override
    public String getCommandName() {
        return commandName;
    }
}
