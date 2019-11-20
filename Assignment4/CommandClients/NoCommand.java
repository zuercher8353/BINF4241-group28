package CommandClients;

public class NoCommand implements Command {

    public void execute() {
        System.out.println("no function to this button");
    }

    @Override
    public String getCommandName() {
        return null;
    }
}
