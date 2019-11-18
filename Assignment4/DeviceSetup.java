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
        ovenCommandHandler.configButtons();
        Microwave microwave = new Microwave();
    }

    HashMap getDevices() {
        HashMap<Device, CommandHandler> copy_devicesMap = devicesMap;
        return copy_devicesMap;
    }

    public void printMainMenu() {
        System.out.println("---------");
        for (Map.Entry<Device, CommandHandler> device : devicesMap.entrySet()) {
            System.out.println(device.getKey().getClass().getSimpleName());
        }
        System.out.println("exit");
        System.out.println("---------");
    }
}
