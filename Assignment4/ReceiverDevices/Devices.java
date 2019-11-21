package ReceiverDevices;

import java.util.ArrayList;

public interface Devices {
    public ArrayList getStateCommands();

    public void setEnded();

    public void switchOn();

    public void checkTimer();

    public void switchOff();

    public void interrupt();
}
