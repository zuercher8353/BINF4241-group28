/*package CommandHandler;
import CommandClients.*;
import CommandClients.MicrowaveCommands.*;
import ReceiverDevices.Microwave;

public class MicrowaveCommandHandler implements CommandHandler {

    private int nrOfCommands = Microwave.DeviceCommands.values().length;
    private Command[] buttonSlots = new Command[nrOfCommands];
    private Microwave microwave;

    public MicrowaveCommandHandler(Microwave microwave){
        this.microwave = microwave;
        for(int i = 0; i < nrOfCommands; i++) {
            buttonSlots[i] = new NoCommand();
        }
    }

    public void configButtons() {
        buttonSlots[0] = new MicrowaveCommandOn(microwave);
        buttonSlots[1] = new MicrowaveCommandSetTemp(microwave);
        buttonSlots[3] = new MicrowaveCommandStartBaking(microwave);
        buttonSlots[4] = new MircowaveCommandSetTimer(microwave);
        buttonSlots[5] = new MicrowaveCommandCheckTimer(microwave);
        buttonSlots[2] = new MicrowaveCommandOff(microwave);
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
}*/
