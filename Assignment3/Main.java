import java.util.ArrayList;
import java.util.List;

// chessBoard [x][y]
// x-Axis: intAxis X numeric 0 - 7
// y-Axis: charAxis Y character a-b

public class Main {
    public static void main(String[] args) {

        Board board = Board.getInstance();
        Players players = new Players();
        Reader reader = new Reader();
        Scoreboard scoreBoard = new Scoreboard();
        board.registerObserver(scoreBoard);
        players.createPlayers();

        board.printBoard();

        List<Player> allPlayers = players.getPlayers();
        boolean gameEnded = false;
        int score;


        while(!gameEnded) {
            for (Player player : allPlayers) {

                System.out.println("It's your turn, " + player.getName() + " (" +player.getColourSTR()+ ")");
                if(board.isCheck(player, players)){
                    if(board.isCheckMated(player,players)){
                        System.out.println("It is checkmate"); //add good print
                        Player otherplayer = players.otherPlayer(player);
                        System.out.println(otherplayer.getName() + " wins!!");
                        gameEnded = true;
                        break;
                    }
                    else{
                        System.out.println("You are in check");
                    }
                    System.out.println();}

                boolean possibleMove = false;
                while (!possibleMove) {

                    ArrayList moveArray = reader.readMove();

                    if(moveArray.size() == 6) {
                        if(board.promoteFigure(moveArray,player,players)) {
                            possibleMove = true;
                        }
                    }
                    else if(moveArray.size() == 7){
                        if(board.enPassant(moveArray,player,players)) {
                            possibleMove = true;
                        }
                    }

                    else if (moveArray.get(0).equals("Rochade_Small")) {
                        if (board.shortRochade(player, players)){
                            possibleMove = true;
                        }
                    }
                    else if(moveArray.get(0).equals("Rochade_Large")) {
                        if (board.longRochade(player, players)){
                            possibleMove = true;
                        }
                    }
                    else {
                        if (board.tryMove(moveArray, player, players)) { //check if move is possible
                            possibleMove = true;
                        }
                    }
                }
                if(player.isPlayerWhite()){
                    score= scoreBoard.getScoreWhite();
                }
                else {
                    score = scoreBoard.getScoreBlack();
                }
                System.out.println(player.getName() + ", score: " + score );
                board.printBoard();
            }
        }
    }
}
