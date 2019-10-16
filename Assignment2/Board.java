import java.lang.reflect.Array;

public class Board {
    private int boardsize = 8;

    private Figure[][] chessBoard = new Figure[boardsize][boardsize];

    public Board() {
        for (int i=0;i<boardsize;i++) {
            for (int j=0; i<boardsize;i++)
                chessBoard[i][j] = null;
        }
        for (int k=0;k<boardsize;k++) {
            //Board[7][k] = new Bauer();
            //Board[2][k] = new Bauer();
        }
    }

    public void printBoard() {
        System.out.print("   0   1   2   3   4   5   6   7\n"); //x axis
        for (int i=0;i<boardsize;i++) {
            System.out.print(i+" ");            //y axis (on the left)
            for (int j=0; j<boardsize;j++) {
                if (chessBoard[i][j] == null) {
                    System.out.print("[  ]");
                } else {
                    //print Figure Type and Color
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void removeFigure(int i, int j) {

    }

    //public void moveFigure(//whole move array) {
        //kill figure or just move
    //}

    public Figure[][] getFiguresArray() {
        return chessBoard;
    }

    //public tryMove(inputarray) {
        //figure auf dem input
        // meine Figur?
            //figure move islegal, type of move?
                //figure path? return arraylist path of fields stepped
                    //check if arraylist path is free on board
                        //yes?
                            //is endfield occupied by own figure?
                                //no?
                                    //move
                                //yes?
                                    // dont move, field is occupied by own figure , tell user cannot move
                        //no?
                            //there is a figure in your way
            //figure is not able to move like this, return false
        // nicht meine Figur?

        //return array
    //}
}
