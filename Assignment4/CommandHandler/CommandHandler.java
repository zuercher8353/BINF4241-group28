package CommandHandler;

public interface CommandHandler {

    public void configButtons();
    public void handleInput(String userInput);
    public boolean validateInput(String userInput);
    public void printDeviceMenu();

}
