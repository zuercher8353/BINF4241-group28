import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import CommandClients.Command;
import CommandClients.OvenCommandOn;
import ReceiverDevices.*;

//Invoker
public class Smartphone {
    public static void main(String[] args) {

        Oven oven = new Oven();
        OvenCommandOn ovenCommandOn = new OvenCommandOn(oven);

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
        while(!inputDevice.equals("exit")){
            if(validateInput(inputDevice)){
                for(Device device:deviceArray) {
                    if(device.getClass().getSimpleName().equals(inputDevice)) {
                        device.printDeviceMenu();

                    }
                }
                String inputCommand = userInput.nextLine();
                while(!inputCommand.equals("back")) {

                }
            } else {
                System.out.println("Device not available");
            }
            inputDevice = userInput.nextLine();
        }
    }
    public void setCommand(){

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


