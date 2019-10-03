import java.util.Scanner;
import java.util.*;

public class BoardGame {
    public static void main(String[] args) {
        int roundCount = 0;

        //START Init Players
        PlayerSetup playersetup = new PlayerSetup();
        Player[] players = playersetup.setup();
        for (Player player : players) {
            System.out.println("Player Nr. " + player.playerid + ": " + player.name);
        }
        //END Init Players

        //START let users play
        //while End Square not occupied

        for (Player player : players) {
            player.takeTurn();
        }
        //
    }

}


