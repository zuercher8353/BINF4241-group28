import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import CommandHandler.*;
import ReceiverDevices.*;

//Invoker, Main
public class Smartphone {

    public static void main(String[] args) {

        DeviceSetup deviceSetup = new DeviceSetup();
        HashMap<WashingDevices, CommandHandler> devicesMap = deviceSetup.getDevices();
        deviceSetup.initButtons();

        //print Main Menu
        deviceSetup.printMainMenu();
        // end print


        System.out.println("Choose WashingDevices: ");
        Scanner userInput = new Scanner(System.in);
        String inputDevice = userInput.nextLine();

        CommandHandler deviceCommandHandler = new NoCommandHandler();
        while(!inputDevice.equals("exit")){
            if(deviceSetup.validateInput(inputDevice)){
                for (Map.Entry<WashingDevices, CommandHandler> device : devicesMap.entrySet()) {
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
                    }
                    else {
                        if (!inputCommand.equals("back")) {
                            System.out.println("Command not available");
                        }
                    }

                    if (!inputCommand.equals("back")) {
                        deviceCommandHandler.printCommandMenu();
                    }
                }
                deviceSetup.printMainMenu();
                System.out.println("Choose WashingDevices: ");
                inputDevice = userInput.nextLine();
            } else {
                System.out.println("WashingDevices not available");
                System.out.println("Choose WashingDevices: ");
                inputDevice = userInput.nextLine();
            }
        }
        System.out.println("Smartphone turning off");
    }


}


