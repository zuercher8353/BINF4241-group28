import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int roundCount = 0;

        //START Init Board

        Board board = new Board();
        Square[] squares = board.initsquare();
        //END Init Board

        //START Init Players
        PlayerSetup playersetup = new PlayerSetup();
        Player[] players = playersetup.setup();
        for (Player player : players) {
            System.out.println("Player Nr. " + player.playerid + ": " + player.name);
        }
        //END Init Players

        //START players play
        while(true) {

            for (Player player : players) {
                player.takeTurn(squares);
            }
        }
        //END  players play
    }

}


