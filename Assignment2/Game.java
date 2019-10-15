import java.util.Scanner;

public class Game {

    public Players players = new Players();
    public Board board = new Board();



    public void createPlayers() {

        int nrOfPlayers = 0;

        while (nrOfPlayers < 2) {
            Scanner inputPlayer = new Scanner(System.in);  // Create a Scanner object
            System.out.print("Enter Name: ");
            String inputPlayerName = inputPlayer.nextLine(); // Read Input
            Player player = new Player(inputPlayerName); // Create New Player
            players.add(player);

            nrOfPlayers += 1;
        }
    }

}
