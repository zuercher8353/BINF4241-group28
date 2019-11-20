package CommandClients;

public interface Command {
    public String commandName = "";
    public void execute();
    public String getCommandName();
}
