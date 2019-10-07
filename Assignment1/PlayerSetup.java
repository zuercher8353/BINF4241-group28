import java.util.Scanner;

public class PlayerSetup {

    public Player[] setup() {

        int playerCount = 0;

        //START read amount of players -- 2-4 and only accepting integers
        boolean correctPlayerCount = false;
        while (!correctPlayerCount) {
            try {
                System.out.print("How many players? (2-4) ");
                Scanner playerCount_players = new Scanner(System.in);
                playerCount = playerCount_players.nextInt();
                if (playerCount <= 4 && playerCount >= 2) {
                    correctPlayerCount = true;
                } else {
                    System.out.println("Choose 2, 3 or 4 players");
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        //END read amount of players

        //START get player names
        Player[] players = new Player[playerCount];
        for (
                int i = 0;
                i < playerCount; i++) {

            System.out.print("Name of player Nr. " + (i+1) + ": ");
            Scanner input = new Scanner(System.in);
            String playerName = input.nextLine();
            players[i] = new Player(playerName);
        }
        //END get player names

        return players;
    }
}
