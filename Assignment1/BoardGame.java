import java.util.Scanner;
import java.util.*;

public class BoardGame {
    public static void main(String[] args) {
        PlayerSetup playersetup = new PlayerSetup();
        Player[] players = playersetup.setup();
        for (Player player : players) {
            System.out.println("Player Nr. "+ player.playerid +": " + player.name);
        }
    }
}


