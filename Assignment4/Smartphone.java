import java.util.Scanner;

//Invoker
public class Smartphone {
    public static void main(String[] args) {
        for (DeviceNames deviceNames : DeviceNames.values()) {
            System.out.println(deviceNames);
        }
        System.out.println("back");
        Scanner userInput = new Scanner(System.in);
        String inputDevice = userInput.nextLine();
        while(!inputDevice.equals("back")){
            if(validateInput(inputDevice)){

            }
        }
    }
    public void setCommand(){

    }

    public static boolean validateInput(String userInput) {

        for (DeviceNames deviceName : DeviceNames.values()) {
            if (deviceName.name().equals(userInput)) {
                return true;
            }
        }
        return false;
    }
}


