import java.util.List;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        Players players = new Players();
        Reader reader = new Reader();
        players.createPlayers();

        board.printBoard();
        boolean gameEnded = false;

        //TODO resolve issue with Players List Array
        List<Player> allPlayers = players.getPlayers();

        //while(!gameEnded) {
            for (Player player : allPlayers) {
                System.out.println(player.getName());
                int[] moveArray = reader.readMove();
            }
        //}
    }
}
