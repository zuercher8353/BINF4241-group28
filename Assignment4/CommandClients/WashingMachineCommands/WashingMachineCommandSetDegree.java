package CommandClients.WashingMachineCommands;

import CommandClients.Command;
import ReceiverDevices.Oven;
import ReceiverDevices.WashingMachine;

import java.util.Scanner;

public class WashingMachineCommandSetDegree implements Command {

    private WashingMachine washingMachine;
    private String commandName = WashingMachine.DeviceCommands.SetUpDegree.name();

    public WashingMachineCommandSetDegree(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    @Override
    public void execute() {
        Scanner scannerTemp = new Scanner(System.in);
        int inputTemp = -1;
        while (true){
            System.out.println("enter degrees 40, 60 or 90: ");
            String input = scannerTemp.next();
            try{
                inputTemp = Integer.parseInt(input);
                if (inputTemp == 40 || inputTemp == 60 || inputTemp == 90){
                    break;
                } else {
                    System.out.println("must be 40, 60 or 90 degrees ");
                }
            } catch (NumberFormatException ne){
                System.out.println("must be a number");
            }
        }
        washingMachine.setDegree(inputTemp);
    }

    @Override
    public String getCommandName() {
        return commandName;
    }
}
