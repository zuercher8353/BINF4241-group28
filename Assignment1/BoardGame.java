import java.util.Scanner;
import java.util.*;

public class BoardGame {
    public static void main(String[] args) {

        int playerCount = 0;

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

        Player[] players = new Player[playerCount];
        for (
                int i = 0;
                i < playerCount; i++) {

            System.out.println("Name of player Nr. " + (i + 1) + " :");
            Scanner input = new Scanner(System.in);
            String playerName = input.nextLine();
            players[i] = new Player(playerName);
        }
    }
}


