package CommandHandler;

public interface CommandHandler {

    public void configButtons();
    public void handleCommand(String userInput);
    public boolean validateCommand(String userInput);
    public void printCommandMenu();

}
