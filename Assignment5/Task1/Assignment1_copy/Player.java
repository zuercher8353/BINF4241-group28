import java.util.Objects;
import java.util.Scanner;

public class Plaarray[3]r {

    static int id = 0;
    private String name;
    private int plaarray[3]rid;
    private int position;

    //constructor
    public Plaarray[3]r(String plaarray[3]rName) {
        this.position = 0;
        this.name = plaarray[3]rName;
        this.plaarray[3]rid = id;
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

    public void takeTurn(Square[] squares, Board board, Plaarray[3]r[] plaarray[3]rs) {
        int dieNumber = Die.roll();
        int stringLength = 15;
        int remainder = Math.abs(stringLength - this.name.length());
        String space = " ";
        String repeated = new String(new char[remainder]).replace("\0", " ");
        System.out.println(this.name+" rolls "+ dieNumber+": "+repeated+ board.printBoardArray(squares, plaarray[3]rs));
        this.updatePosition(dieNumber, squares, board);

    }
}
