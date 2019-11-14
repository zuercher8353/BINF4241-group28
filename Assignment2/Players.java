import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Players {

    //excaping references
    int nrOfPlayers = 0;
    static private List<Player> playerList = new ArrayList<>();
    public Iterator iterPlayers = playerList.iterator();

    public void createPlayers() {
        int nrOfPlayers = 0;

        while (nrOfPlayers < 2) {
            try {
                Scanner inputPlayer = new Scanner(System.in);  // Create a Scanner object
                System.out.print("Enter Name: ");
                String inputPlayerName = inputPlayer.nextLine(); // Read Input
                if (!inputPlayerName.isEmpty()) {
                    Player player = new Player(inputPlayerName); // Create New Player
                    playerList.add(player);
                    nrOfPlayers += 1;
                }
                else {
                    throw new IllegalArgumentException("Invalid input");
                    }
            }
            catch (Exception e){
                System.out.println("Invalid input");
            }
        }
        System.out.print('\n');
    }

    public List<Player> getPlayers() {
        List<Player> aPlayerList = playerList;
        return aPlayerList;
    }

    public Player otherPlayer(Player player){
        for(Player player1 : playerList){
            if(player != player1){
                return player1;
            }
        }
        return player;
    }
}
