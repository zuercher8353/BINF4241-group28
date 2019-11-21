package ReceiverDevices;

import java.util.ArrayList;

public interface WashingDevices {

    public ArrayList getStateCommands();

    public void setEnded();

    public void switchOn();

    public void setUpProgram(String program);

    public void startWashing();

    public void checkTimer();

    public void switchOff();

    public void interrupt();



}
