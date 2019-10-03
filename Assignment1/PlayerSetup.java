import java.util.Scanner;

public class PlayerSetup {

    public Player[] setup() {
        //return object array of Players, with name and id

        int playerCount = 0;

        //START read amount of players -- 2-4 and only accepting integers
        boolean correctPlayerCount = false;
        while (!correctPlayerCount) {
            try {
                System.out.println("Choose between 2-4 persons");
                System.out.println("How many players want to play? ");
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
        System.out.println("Amount of players: " + playerCount);
        //END read amount of players

        //START get player names
        Player[] players = new Player[playerCount];
        for (
                int i = 0;
                i < playerCount; i++) {

            System.out.println("Name of player Nr. " + (i + 1) + " :");
            Scanner input = new Scanner(System.in);
            String playerName = input.nextLine();
            players[i] = new Player(playerName);
        }
        //END get player names
        return players;
    }
}
