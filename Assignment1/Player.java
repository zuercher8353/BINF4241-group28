import java.util.Objects;
import java.util.Scanner;

public class Player {

    static int id = 0;
    private String name;
    private int playerid;
    private int position;

    //constructor
    public Player(String playerName) {
        this.position = 0;
        this.name = playerName;
        this.playerid = id;
        id += 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void updatePosition(int moveNumber, Square[] squares, Board board) {
        if (this.position + moveNumber >= board.getBoardsize() - 1) {
            this.position = board.getBoardsize() - 1;
        } else {
            int tempPos = this.position + moveNumber;
            if(squares[tempPos].getOccupied()){
                int newPosition = 0;
                squares[this.position].setOccupied(false);
                this.position = newPosition;
            }
            else {
                if (squares[tempPos] instanceof Snake || squares[tempPos] instanceof Ladder) {
                    if(squares[squares[tempPos].getEnd()].getOccupied()){
                        int newPosition = 0;
                        squares[this.position].setOccupied(false);
                        this.position = newPosition;
                    } else {
                        int newPosition = squares[tempPos].getEnd();
                        squares[this.position].setOccupied(false);
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
        int dieNumber = Die.roll();
        int stringLength = 15;
        int remainder = Math.abs(stringLength - this.name.length());
        String space = " ";
        String repeated = new String(new char[remainder]).replace("\0", " ");
        System.out.println(this.name+" rolls "+ dieNumber+": "+repeated+ board.printBoardArray(squares, players));
        this.updatePosition(dieNumber, squares, board);
    }
}
