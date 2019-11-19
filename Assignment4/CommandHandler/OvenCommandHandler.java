package CommandHandler;
import CommandClients.*;
import CommandClients.OvenCommands.*;
import ReceiverDevices.*;

public class OvenCommandHandler implements CommandHandler{

    private int nrOfCommands = 8;
    private Command[] buttonSlots = new Command[nrOfCommands];
    private Oven oven;

    private enum DeviceCommands {
        SwitchOn,
        SwitchOff,
        SetTimer,
        SetTemperature,
        SetUpProgram,
        StartCooking,
        CheckTimer,
        Interrupt
        }

    public OvenCommandHandler(Oven oven){
        this.oven = oven;
        for(int i = 0; i < nrOfCommands; i++) {
            buttonSlots[0] = new NoCommand();
        }
    }

    public void configButtons() {
        buttonSlots[0] = new OvenCommandOn(oven);
        buttonSlots[1] = new OvenCommandInterrupt(oven);
        buttonSlots[2] = new OvenCommandOff(oven);
        buttonSlots[3] = new OvenCommandSetProgram(oven);
        buttonSlots[4] = new OvenCommandCheckTimer(oven);
        buttonSlots[5] = new OvenCommandSetTimer(oven);
        buttonSlots[6] = new OvenCommandStartCooking(oven);
        buttonSlots[7] = new OvenCommandSetTemp(oven);
    }

    public boolean validateCommand(String userInput) {
        int i = 0;
        for(Command buttonSlot : buttonSlots) {
            if (buttonSlot.getCommandName().equals(userInput)) {
                return true;
            }
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
        for (Command buttonSlot : buttonSlots) {
            System.out.println("["+i+"] "+ buttonSlot.getCommandName());
            i++;
        }
        System.out.println("back");
        System.out.println("----------");
    }
}
