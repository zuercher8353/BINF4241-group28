package CommandHandler;

import CommandClients.Command;
import CommandClients.NoCommand;
import CommandClients.DishwasherCommands.*;
import ReceiverDevices.Dishwasher;


public class DishwasherCommandHandler implements CommandHandler{

    // int size = DeviceCommands.values().length;
    private Command[] buttonSlots = new Command[DeviceCommands.values().length];
    private Dishwasher dishwasher;

    private enum DeviceCommands {
        SwitchOn,
        SwitchOff,
        SetUpDegree,
        SetUpProgram,
        CheckTimer,
        Interrupt
    }

    public DishwasherCommandHandler(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
        for(int i = 0; i < DeviceCommands.values().length; i++) {
            buttonSlots[0] = new NoCommand();
        }
    }

    public void configButtons() {
        buttonSlots[0] = new DishwasherCommandOn(dishwasher);
    }

    public boolean validateCommand(String userInput) {
        int i = 0;
        for (DeviceCommands command : DeviceCommands.values()) {
            if (command.name().equals(userInput)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void handleCommand(String userInput) {
        int i = 0;
        for (DeviceCommands command : DeviceCommands.values()) {
            if (command.name().equals(userInput)) {
                buttonSlots[i].execute();
            }
            i++;
        }
    }

    public void printCommandMenu(){
        System.out.println("----------");
        int i = 0;
        for (DeviceCommands commands : DeviceCommands.values()) {
            System.out.println("["+i+"] "+commands);
            i++;
        }
        System.out.println("back");
        System.out.println("----------");
    }
}
