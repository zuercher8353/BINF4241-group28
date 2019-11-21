package CommandHandler;

import CommandClients.Command;
import CommandClients.NoCommand;
import CommandClients.DishwasherCommands.*;
import ReceiverDevices.Dishwasher;

import java.util.ArrayList;


public class DishwasherCommandHandler implements CommandHandler{


    int nrOfCommands = Dishwasher.DeviceCommands.values().length;
    private Command[] buttonSlots = new Command[nrOfCommands];
    private Dishwasher dishwasher;


    public DishwasherCommandHandler(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
        for(int i = 0; i < nrOfCommands; i++) {
            buttonSlots[0] = new NoCommand();
        }
    }

    public void setCommands() {
        buttonSlots[0] = new DishwasherCommandOn(dishwasher);
    }

    public boolean validateCommand(String userInput) {
        int i = 0;
        for (Dishwasher.DeviceCommands command : Dishwasher.DeviceCommands.values()) {
            if (command.name().equals(userInput)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void handleCommand(String userInput) {
        int i = 0;
        for (Dishwasher.DeviceCommands command : Dishwasher.DeviceCommands.values()) {
            if (command.name().equals(userInput)) {
                buttonSlots[i].execute();
            }
            i++;
        }
    }

    public void printCommandMenu(){
        System.out.println("----------");
        int i = 0;
        ArrayList stateCommands = dishwasher.getStateCommands();
        for (Object stateCommand : stateCommands) {
            int iter = 0;
            for(Command buttonSlot : buttonSlots) {

                iter++;
            }
            //System.out.println("[" +buttonNumber+ "]"+stateCommand);
            System.out.println(stateCommand);
        }

        System.out.println("back");
        System.out.println("----------");
    }

}
