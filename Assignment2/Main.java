import java.util.ArrayList;
import java.util.List;

// chessBoard [x][y]
// x-Axis: intAxis X numeric 0 - 7
// y-Axis: charAxis Y character

public class Main {
    public static void main(String[] args) {



        Board board = new Board();
        Players players = new Players();
        Reader reader = new Reader();
        players.createPlayers();

        board.printBoard();

        //TODO resolve issue with Players List Array

        List<Player> allPlayers = players.getPlayers();
        boolean gameEnded = false;
        while(!gameEnded) {
            for (Player player : allPlayers) {

                //TODO Player take turn
                System.out.println("It's your turn, "+player.getName() +" (" +player.getColourSTR()+ ")");
                System.out.println();

                Boolean possibleMove = false;
                while (!possibleMove) {
                    ArrayList moveArray = reader.readMove(); //let player input move
                    if(board.tryMove(moveArray, player)) { //check if move is possible
                        possibleMove = true;
                        board.printBoard();
                    }
                }
                // int[] moveArray = reader.readMove();;
            }
        }
    }
}
