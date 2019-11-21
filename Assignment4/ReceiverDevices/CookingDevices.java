package ReceiverDevices;

import java.util.ArrayList;

public interface CookingDevices {

    public ArrayList getStateCommands();

    public void setEnded();

    public void switchOn();

    public void setTimer(int time);

    public void setTemperature(int temp);

    public void checkTimer();

    public void interrupt();

    public void switchOff();

}
