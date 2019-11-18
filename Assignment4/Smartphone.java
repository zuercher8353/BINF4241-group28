import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import CommandHandler.*;
import ReceiverDevices.*;

//Invoker
public class Smartphone {


    public static void main(String[] args) {

        DeviceSetup deviceSetup = new DeviceSetup();
        HashMap<Device, CommandHandler> devicesMap = deviceSetup.getDevices();
        deviceSetup.initButtons();

        //print Main Menu
        deviceSetup.printMainMenu();
        // end print

        System.out.println("Choose Device: ");
        Scanner userInput = new Scanner(System.in);
        String inputDevice = userInput.nextLine();

        CommandHandler deviceCommandHandler = new NoCommandHandler();
        while(!inputDevice.equals("exit")){
            if(validateInput(inputDevice)){
                for (Map.Entry<Device, CommandHandler> device : devicesMap.entrySet()) {
                    if(device.getKey().getClass().getSimpleName().equals(inputDevice)) {
                        deviceCommandHandler = (CommandHandler) devicesMap.get(device.getKey());
                        deviceCommandHandler.printCommandMenu();
                    }
                }
                String inputCommand = "";
                while(!inputCommand.equals("back")) {
                    System.out.println("Choose Command: ");
                    inputCommand = userInput.nextLine();
                    if (deviceCommandHandler.validateCommand(inputCommand)) {
                        deviceCommandHandler.handleCommand(inputCommand);
                    } else {
                        System.out.println("Command not available");
                    }
                    deviceCommandHandler.printCommandMenu();
                    inputCommand = userInput.nextLine();
                }
                deviceSetup.printMainMenu();
                System.out.println("Choose Device: ");
                inputDevice = userInput.nextLine();
            } else {
                System.out.println("Device not available");
            }
        }
        System.out.println("Smartphone turning off");
    }

    private static boolean validateInput(String userInput) {

        for (DeviceNames deviceName : DeviceNames.values()) {
            if (deviceName.name().equals(userInput)) {
                return true;
            }
        }
        return false;
    }
}

