import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

import CommandHandler.*;
import CommandHandler.OvenCommandHandler;
import ReceiverDevices.*;

//Invoker
public class Smartphone {
    public static void main(String[] args) {

        HashMap map = new HashMap();
        Oven oven = new Oven();
        OvenCommandHandler ovenCommandHandler = new OvenCommandHandler(oven);
        map.put(oven,ovenCommandHandler);
        ovenCommandHandler.configButtons();
        Microwave microwave = new Microwave();
        //Dishwasher dishwasher;
        //WashingMachine washingmachine;
        //CleaningRobot cleaningrobot;

        final Device[] deviceArray = {oven, microwave};

        //print Main Menu
        for (Device device: deviceArray) {
            System.out.println(device.getClass().getSimpleName());
        }
        System.out.println("exit");
        System.out.println("---------");
        // end print

        System.out.println("Choose Device: ");
        Scanner userInput = new Scanner(System.in);
        String inputDevice = userInput.nextLine();

        CommandHandler deviceCommandHandler = new NoCommandHandler();

        while(!inputDevice.equals("exit")){
            if(validateInput(inputDevice)){
                for(Device device:deviceArray) {
                    if(device.getClass().getSimpleName().equals(inputDevice)) {
                        deviceCommandHandler = (CommandHandler) map.get(device);
                        deviceCommandHandler.printDeviceMenu();
                    }
                }

                String inputCommand = "";
                while(!inputCommand.equals("back")) {
                    inputCommand = userInput.nextLine();
                    deviceCommandHandler.validateInput(inputCommand);
                    deviceCommandHandler.handleInput(inputCommand);
                }

            } else {
                System.out.println("Device not available");
            }
            inputDevice = userInput.nextLine();
        }
    }


    public void printMainMenu() {

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


