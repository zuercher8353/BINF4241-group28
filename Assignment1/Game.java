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
                System.out.print("Choose a boardsize between 10 and 100: ");
                Scanner inputBoardSize = new Scanner(System.in);
                boardsize = inputBoardSize.nextInt();
                if (boardsize >=10 && boardsize <= 100){
                    correctBoardsize = true;
                }else{
                    System.out.println("Choose between 10 and 100 squares\n");
                }
            } catch (Exception e){
                System.out.println("Invalid input\n");
            }
        }
        return boardsize;
    }

    public  void playGame(Board board,Square[] squares, Player[] players) {
        Boolean gameEnded = false;
        System.out.println("Intitial State:          " + board.printBoardArray(squares,players));
        while (!gameEnded) {
            for (Player player : players) {
                if (gameEnded) {
                    break;
                } else {
                    player.takeTurn(squares, board, players);
                    if (player.getPosition() >= board.getBoardsize() - 1) {
                        System.out.println("Final State:             " + board.printBoardArray(squares, players));
                        System.out.println("\n************ "+player.getName() + " WINS!"+" ************");
                        System.out.println("\n------------GAME ENDED------------\n");
                        gameEnded = true;
                    }
                }
            }
        }
    }
}
