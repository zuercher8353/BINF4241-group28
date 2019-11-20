package CommandClients.CleaningRobotCommands;

import CommandClients.Command;
import ReceiverDevices.CleaningRobot;

import java.util.Scanner;

public class RobotCommandSetTimer implements Command {
    private CleaningRobot robot;
    private String commandName = CleaningRobot.DeviceCommands.SetTimer.name();

    public RobotCommandSetTimer(CleaningRobot robot) {
        this.robot = robot;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
        Scanner scannerTime = new Scanner(System.in);
        int inputTime = -1;
        while (true) {
            System.out.print("enter timer (in sec.): ");
            String input = scannerTime.next();
            try {
                inputTime = Integer.parseInt(input);
                if (inputTime >= 0)
                    break;
                else {
                    System.out.println("time must be > 0");
                }
            } catch (NumberFormatException ne) {
                System.out.println("must be a number");
            }
        }
        robot.setTimer(inputTime);
    }
}
