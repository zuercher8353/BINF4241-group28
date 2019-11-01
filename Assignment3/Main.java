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

        //List<Player> allPlayers = players.getPlayers();
        boolean gameEnded = false;
        int score;

        while (!gameEnded) {

            //making new iterator to start iteration from beginning
            PlayerIterator playerIterator = players.createPlayerIterator();
            while (playerIterator.hasNext()) {

                Player currentPlayer = playerIterator.next();

                System.out.println("It's your turn, " + currentPlayer.getName() + " (" + currentPlayer.getColourSTR() + ")");
                if (board.isCheck(currentPlayer, playerIterator)) {
                    if (board.isCheckMated(currentPlayer, playerIterator)) {
                        System.out.println("It is checkmate"); //add good print
                        //Player otherplayer = players.otherPlayer(player);
                        Player nextPlayer = playerIterator.next();
                        //System.out.println(otherplayer.getName() + " wins!!");
                        System.out.println(nextPlayer.getName() + " wins!!");
                        gameEnded = true;
                        break;
                    } else {
                        System.out.println("You are in check");
                    }
                    System.out.println();
                }

                boolean possibleMove = false;
                while (!possibleMove) {

                    ArrayList moveArray = reader.readMove();

                    if (moveArray.size() == 6) {
                        if (board.promoteFigure(moveArray, currentPlayer, playerIterator)) {
                            possibleMove = true;
                        }
                    } else if (moveArray.size() == 7) {
                        if (board.enPassant(moveArray, currentPlayer, playerIterator)) {
                            possibleMove = true;
                        }
                    } else if (moveArray.get(0).equals("Rochade_Small")) {
                        if (board.shortRochade(currentPlayer, playerIterator)) {
                            possibleMove = true;
                        }
                    } else if (moveArray.get(0).equals("Rochade_Large")) {
                        if (board.longRochade(currentPlayer, playerIterator)) {
                            possibleMove = true;
                        }
                    } else {
                        if (board.tryMove(moveArray, currentPlayer, playerIterator)) { //check if move is possible
                            possibleMove = true;
                        }
                    }
                }
                if(currentPlayer.isPlayerWhite()){
                    score= scoreBoard.getScoreWhite();
                }
                else {
                    score = scoreBoard.getScoreBlack();
                }
                System.out.println(currentPlayer.getName() + ", score: " + score );
                board.printBoard();
            }
        }
    }
}
