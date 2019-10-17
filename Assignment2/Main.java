import java.util.List;

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
                System.out.println("It's your turn, "+player.getName()+"\n");
                int[] moveArray = reader.readMove();
                //while (!board.tryMove(inputarray))
                // tell user move is not legal, read another input
                // int[] moveArray = reader.readMove();;
            }
        }
    }
}
