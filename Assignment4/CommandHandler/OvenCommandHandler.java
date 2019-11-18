package CommandHandler;

import CommandClients.Command;
import CommandClients.NoCommand;
import CommandClients.OvenCommands.OvenCommandOn;
import ReceiverDevices.Oven;

public class OvenCommandHandler implements CommandHandler{

    // int size = DeviceCommands.values().length;
    private Command[] buttonSlots = new Command[DeviceCommands.values().length];
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
        for(int i = 0; i < DeviceCommands.values().length; i++) {
            buttonSlots[0] = new NoCommand();
        }
    }

    public void configButtons() {
        buttonSlots[0] = new OvenCommandOn(oven);
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
        for (Command buttonSlot : buttonSlots) {
            System.out.println("["+i+"] "+ buttonSlot.getCommandName());
            i++;
        }
        System.out.println("back");
        System.out.println("----------");
    }
}
