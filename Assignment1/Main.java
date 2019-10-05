import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int roundCount = 1;
        int boardsizeCount = 0;

        //START Init Board
        boolean correctBoardsize = false;
        while(!correctBoardsize) {
            try {
                System.out.println("Choose a boardsize between 10 and 50");
                Scanner boardsize = new Scanner(System.in);
                boardsizeCount = boardsize.nextInt();
                if (boardsizeCount >=10 && boardsizeCount <= 50){
                    correctBoardsize = true;
                }else{
                    System.out.println("Choose between 10 and 50 squares");
                }
            } catch (Exception e){
                System.out.println("Invalid input");
            }
        }
        Board board = new Board(boardsizeCount);
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


