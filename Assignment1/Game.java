import java.util.Scanner;

public class Game {

    public Player[] setupPlayers() {
        PlayerSetup playersetup = new PlayerSetup();
        return playersetup.setup();
    }

    public int inputBoardsize() {
        boolean correctBoardsize = false;
        int boardsize = 0;
        while(!correctBoardsize) {
            try {
                System.out.print("Choose a boardsize between 10 and 50: ");
                Scanner inputBoardSize = new Scanner(System.in);
                boardsize = inputBoardSize.nextInt();
                if (boardsize >=10 && boardsize <= 50){
                    correctBoardsize = true;
                }else{
                    System.out.println("Choose between 10 and 50 squares\n");
                }
            } catch (Exception e){
                System.out.println("Invalid input\n");
            }
        }
        return boardsize;
    }

    public  void playGame(Board board,Square[] squares, Player[] players) {
        Boolean gameEnded = false;
        System.out.println("Intitial State: " + board.printBoardArray(squares,players));

        while (!gameEnded) {
            //System.out.println("\n------------ROUND " + roundCount + "------------");
            for (Player player : players) {
                if (gameEnded) {
                    break;
                } else {
                    player.takeTurn(squares, board, players);
                    if (player.position >= board.getBoardsize() - 1) {
                        System.out.println("Final State: " + board.printBoardArray(squares, players));
                        System.out.println("\n************ "+player.name + " WINS!"+" ************");
                        System.out.println("\n------------GAME ENDED------------\n");
                        gameEnded = true;
                    }
                }
            }
        }
    }
}
