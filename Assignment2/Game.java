import java.util.Scanner;

public class Game {

    public Players players = new Players();
    public Board board = new Board();


    public void runGame() {
        boolean gameEnded = false;
        board.printBoard();

        //TODO resolve issue with Players List Array
        //while(!gameEnded) {
            //for(Player player: players) {
            //}
        //}

    }

    public void createPlayers() {

        int nrOfPlayers = 0;

        while (nrOfPlayers < 2) {
            try {
                Scanner inputPlayer = new Scanner(System.in);  // Create a Scanner object
                System.out.print("Enter Name: ");
                String inputPlayerName = inputPlayer.nextLine(); // Read Input
                if (!inputPlayerName.isEmpty()) {
                    Player player = new Player(inputPlayerName); // Create New Player
                    players.add(player);

                    nrOfPlayers += 1;
                }
            }
            catch (Exception e){
                System.out.println("Invalid input");
            }
        }
        System.out.print('\n');
    }
}