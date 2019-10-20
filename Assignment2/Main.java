import java.util.ArrayList;
import java.util.List;

// chessBoard [x][y]
// x-Axis: intAxis X numeric 0 - 7
// y-Axis: charAxis Y character a-b

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

                System.out.println("It's your turn, " + player.getName() + " (" +player.getColourSTR()+ ")");
                System.out.println();
                if(board.isCheck(player, players)){
                    if(board.isCheckMated(player,players)){
                        System.out.println("Your checkmated"); //add good print
                        //gameEnded = true;
                    }
                    else{
                        System.out.println("You are in check");
                    }
                    System.out.println();}

                boolean possibleMove = false;
                while (!possibleMove) {
                    //let player input move
                    ArrayList moveArray = reader.readMove();

                    //if (moveArray.get(0).equals("Rochade_Small")) {}
                    //else if(moveArray.get(0).equals("Rochade_Large")) {}

                    if(moveArray.size() == 6) {
                        if(board.promoteFigure(moveArray,player,players)) {
                            possibleMove = true;
                        }
                    }
                    else {
                        if (board.tryMove(moveArray, player, players)) { //check if move is possible
                            possibleMove = true;
                        }
                    }
                }
                board.printBoard();
            }
        }
    }
}
