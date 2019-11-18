package CommandHandler;

import CommandClients.Command;
import CommandClients.NoCommand;
import ReceiverDevices.Microwave;

public class MicrowaveCommandHandler {

    private int nrOfCommands = 8;
    private Command[] buttonSlots;
    private Microwave microwave;

    public MicrowaveCommandHandler(Microwave microwave){
        this.microwave = microwave;
        for(int i = 0; i < nrOfCommands; i++) {
            buttonSlots[i] = new NoCommand();
        }
    }

    public void configButtons() {

    }

    public boolean validateCommand(String userInput) {
        int i = 0;
        for (Command buttonSlot : buttonSlots) {
            if (buttonSlot.getCommandName().equals(userInput)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void handleCommand(String userInput) {
        int i = 0;
        for (Command buttonSlot: buttonSlots) {
            if (buttonSlot.getCommandName().equals(userInput)) {
                buttonSlots[i].execute();
            }
            i++;
        }
    }

    public void printCommandMenu(){
        System.out.println("----------");
        int i = 0;
        for (Command buttonSlot : buttonSlots) {
            System.out.println("["+i+"] "+buttonSlot.getCommandName());
            i++;
        }
        System.out.println("back");
        System.out.println("----------");
    }
}
