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
            int tempPos = this.position + moveNumber;
            if(squares[tempPos].getOccupied()){
                //System.out.println("You landed on an occupied pos");
                int newPosition = 0;
                squares[this.position].setOccupied(false);
                //System.out.println("You moved from pos " + this.position + " to pos " + newPosition);
                this.position = newPosition;
            }
            else {
                if (squares[tempPos] instanceof Snake || squares[tempPos] instanceof Ladder) {
                    if (squares[tempPos] instanceof Snake){
                        //System.out.println("You encountered a snake");
                    }else {
                        //System.out.println("You encountered a ladder");
                    }

                    if(squares[squares[tempPos].getEnd()].getOccupied()){
                        //System.out.println("You landed on an occupied pos");
                        int newPosition = 0;
                        squares[this.position].setOccupied(false);
                        //System.out.println("You moved from pos " + this.position + " to pos " + newPosition);
                        this.position = newPosition;
                    } else {
                        int newPosition = squares[tempPos].getEnd();
                        squares[this.position].setOccupied(false);
                        //System.out.println("You moved from pos " + this.position + " to pos " + newPosition);
                        this.position = newPosition;
                        squares[this.position].setOccupied(true);
                    }
                }
                else{
                    squares[this.position].setOccupied(false);
                    this.position += moveNumber;
                    squares[this.position].setOccupied(true);
                }
            }

        }
    }

    public void takeTurn(Square[] squares, Board board, Player[] players) {
        //System.out.println("Final State: " + board.printBoardArray(squares, players));
        /*System.out.println("It is your turn, " + this.name + "!");
        System.out.println("Right now, you're on square " + this.position);
        System.out.println("Press ENTER to roll the die");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();*/
        int dieNumber = Die.roll();
        System.out.println(this.name+" rolls "+ dieNumber+ " :" + board.printBoardArray(squares, players));
        this.updatePosition(dieNumber, squares, board);
        //System.out.println("Your new Position: " + this.position);
    }
}
