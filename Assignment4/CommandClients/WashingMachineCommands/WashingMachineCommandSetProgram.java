package CommandClients.WashingMachineCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;
import ReceiverDevices.WashingMachine;

import java.util.Scanner;

public class WashingMachineCommandSetProgram implements Command {
    private WashingMachine washingMachine;
    private String commandName = WashingMachine.DeviceCommands.SetUpProgram.name();

    public WashingMachineCommandSetProgram(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    @Override
    public void execute() {
        //print Program Menu without notSet
        System.out.println("---------");
        for (Enum WashingMachinePrograms : WashingMachine.WashingMachinePrograms.values()) {
            if (!WashingMachinePrograms.name().equals("notSet")) {
                System.out.println(WashingMachinePrograms.name());
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
                for (Enum WashingMachinePrograms : WashingMachine.WashingMachinePrograms.values()) {
                    if (WashingMachinePrograms.name().equals(inputProgram)) {
                        washingMachine.setUpProgram(WashingMachinePrograms.name());
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
