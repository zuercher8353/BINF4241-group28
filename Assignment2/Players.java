import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Players {

    //excaping references
    int nrOfPlayers = 0;
    static private List<Player> playerList = new ArrayList<>();

    public void createPlayers() {
        int nrOfPlayers = 0;

        while (nrOfPlayers < 2) {
            Scanner inputPlayer = new Scanner(System.in);  // Create a Scanner object
            System.out.print("Enter Name: ");
            //TODO if empty name
            String inputPlayerName = inputPlayer.nextLine(); // Read Input
            Player player = new Player(inputPlayerName); // Create New Player
            playerList.add(player);

            nrOfPlayers += 1;
        }
        System.out.print('\n');
    }

    public void add(Player player) {
        playerList.add(player);
    }

    public List<Player> getPlayers() {
        List<Player> aPlayerList = playerList;
        return aPlayerList;
    }

    public String getPlayerName(Player aPlayer) {
        for (Player player : playerList) {
            if (player == aPlayer) {
                return player.getName();
            }
        }

        return null;
    }
}
