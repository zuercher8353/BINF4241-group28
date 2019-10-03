import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int roundCount = 1;

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
        Boolean gameEnded = false;
        while (!gameEnded) {
            System.out.println("\n------------ROUND " + roundCount + "------------");
            for (Player player : players) {
                if (gameEnded) {
                    break;
                } else {
                    player.takeTurn(squares, board);
                    if (player.position >= board.getBoardsize() - 1) {
                        System.out.println("************ "+player.name + " WINS!"+" ************");
                        System.out.println("------------GAME ENDED------------\n");
                        gameEnded = true;
                    }
                    else {
                        System.out.println("\n-----Next Player-----\n");
                    }
                }
            }
            roundCount++;
        }

        //END  players play
    }

}


