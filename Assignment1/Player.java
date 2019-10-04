import java.util.Objects;
import java.util.Scanner;

public class Player {

    static int id = 0;
    public String name;
    public int playerid;
    public int position;

    //constructor
    public Player(String playerName) {
        this.position = 0; //are square id starting at 0?
        this.name = playerName;
        this.playerid = id;
        id += 1;
    }

    public void updatePosition(int moveNumber, Square[] squares, Board board) {
        if (this.position + moveNumber >= board.getBoardsize() - 1) {
            this.position = board.getBoardsize() - 1;
        } else {
            this.position = this.position + moveNumber;
            if (squares[this.position] instanceof Snake) {
                System.out.println("You encountered a snake");
                int newPosition = squares[this.position].getEnd();
                System.out.println("You moved from pos " + this.position + " to pos " + newPosition);
                this.position = newPosition;
            }
            if (squares[this.position] instanceof Ladder) {
                System.out.println("Your encountered a ladder");
                int newPosition = squares[this.position].getEnd();
                System.out.println("You moved from pos " + this.position + " to pos " + newPosition);
                this.position = newPosition;
            }
        }
    }

    public void takeTurn(Square[] squares, Board board) {
        System.out.println("It is your turn, " + this.name + "!");
        System.out.println("Right now, you're on square " + this.position);
        System.out.println("Press ENTER to roll the die");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int dieNumber = Die.roll();
        System.out.println("The die is showing " + dieNumber);
        this.updatePosition(dieNumber, squares, board);
        System.out.println("Your new Position: " + this.position);
    }
}
