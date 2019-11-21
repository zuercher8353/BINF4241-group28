import CommandHandler.*;
import ReceiverDevices.*;

import java.util.HashMap;
import java.util.Map;

class DeviceSetup {

    private HashMap<Devices, CommandHandler> devicesMap = new HashMap<Devices, CommandHandler>();


    DeviceSetup() {

        //init an oven and add to devicemap
        Oven oven = new Oven();
        OvenCommandHandler ovenCommandHandler = new OvenCommandHandler(oven);
        devicesMap.put(oven,ovenCommandHandler);

        Microwave microwave = new Microwave();
        MicrowaveCommandHandler microwaveCommandHandler = new MicrowaveCommandHandler(microwave);
        devicesMap.put(microwave, microwaveCommandHandler);

        WashingMachine washingMachine = new WashingMachine();
        WashingMachineCommandHandler washingMachineCommandHandler = new WashingMachineCommandHandler(washingMachine);
        devicesMap.put(washingMachine, washingMachineCommandHandler);

        Dishwasher dishwasher = new Dishwasher();
        DishwasherCommandHandler dishwasherCommandHandler = new DishwasherCommandHandler(dishwasher);
        devicesMap.put(dishwasher, dishwasherCommandHandler);

        CleaningRobot robot = new CleaningRobot();
        CleaningRobotCommandHandler robotCommandHandler = new CleaningRobotCommandHandler(robot);
        devicesMap.put(robot,robotCommandHandler);

    }

    HashMap getDevices() {
        HashMap<Devices, CommandHandler> copy_devicesMap = devicesMap;
        return copy_devicesMap;
    }

    void initButtons() {
        for (Map.Entry<Devices, CommandHandler> device : devicesMap.entrySet()) {
            device.getValue().setCommands();
        }
    }

    void printMainMenu() {
        System.out.println("---------");
        for (Map.Entry<Devices, CommandHandler> device : devicesMap.entrySet()) {
            System.out.println(device.getKey().getClass().getSimpleName());
        }
        System.out.println("exit");
        System.out.println("---------");
    }

    boolean validateInput(String userInput) {

        for (Map.Entry<Devices, CommandHandler> device : devicesMap.entrySet()) {
            if (device.getKey().getClass().getSimpleName().equals(userInput)) {
                return true;
            }
        }
        return false;
    }
}
