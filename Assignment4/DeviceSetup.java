import CommandHandler.*;
import ReceiverDevices.Device;
import ReceiverDevices.Microwave;
import ReceiverDevices.Oven;

import java.util.HashMap;
import java.util.Map;

class DeviceSetup {

    private HashMap<Device, CommandHandler> devicesMap = new HashMap<Device, CommandHandler>();

    DeviceSetup() {
        Oven oven = new Oven();
        OvenCommandHandler ovenCommandHandler = new OvenCommandHandler(oven);
        devicesMap.put(oven,ovenCommandHandler);
        Microwave microwave = new Microwave();
        MicrowaveCommandHandler microwaveCommandHandler = new MicrowaveCommandHandler(microwave);
        devicesMap.put(microwave, microwaveCommandHandler);
    }

    HashMap getDevices() {
        HashMap<Device, CommandHandler> copy_devicesMap = devicesMap;
        return copy_devicesMap;
    }

    void initButtons() {
        for (Map.Entry<Device, CommandHandler> device : devicesMap.entrySet()) {
            device.getValue().configButtons();
        }
    }

    void printMainMenu() {
        System.out.println("---------");
        for (Map.Entry<Device, CommandHandler> device : devicesMap.entrySet()) {
            System.out.println(device.getKey().getClass().getSimpleName());
        }
        System.out.println("exit");
        System.out.println("---------");
    }
}
