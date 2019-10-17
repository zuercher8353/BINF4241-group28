import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Board {
    private int boardsize = 8;

    private Object[][] chessBoard = new Object[boardsize][boardsize];

    public Board() {
        for (int i = 0; i < boardsize; i++) {
            for (int j = 0; i < boardsize; i++)
                chessBoard[i][j] = null;
        }

        //START initialize figures, black at the top, white at the bottom

        //init all pawns
        for (int k = 0; k < boardsize; k++) {
            chessBoard[1][k] = new Pawn(false);
            chessBoard[6][k] = new Pawn(true);
        }
        //init towers
        chessBoard[0][0] = new Rock(false);
        chessBoard[0][7] = new Rock(false);
        chessBoard[7][0] = new Rock(true);
        chessBoard[7][7] = new Rock(true);

        //init knights
        chessBoard[0][1] = new Knight(false);
        chessBoard[0][6] = new Knight(false);
        chessBoard[7][1] = new Knight(true);
        chessBoard[7][6] = new Knight(true);

        //init bishops
        chessBoard[0][2] = new Bishop(false);
        chessBoard[0][5] = new Bishop(false);
        chessBoard[7][2] = new Bishop(true);
        chessBoard[7][5] = new Bishop(true);

        //init queen
        chessBoard[0][3] = new Queen(false);
        chessBoard[7][3] = new Queen(true);

        //init king
        chessBoard[0][4] = new King(false);
        chessBoard[7][4] = new King(false);

        //START initialize figures
    }


    public void printBoard() {
        System.out.print("   a    b    c    d    e    f    g    h\n"); //x axis
        for (int i = 0; i < boardsize; i++) {
            System.out.print(i + " ");            //y axis (on the left)
            for (int j = 0; j < boardsize; j++) {
                if (chessBoard[i][j] == null) {
                    System.out.print("[  ] ");
                } else {
                    if (chessBoard[i][j].getClass() == Bishop.class) {
                        Bishop bishop = (Bishop) chessBoard[i][j];
                        if (bishop.iswhite()) {
                            System.out.print("[W"+bishop.getToken()+"] ");
                        } else {
                            System.out.print("[B"+bishop.getToken()+"] ");
                        }

                    }
                    else if (chessBoard[i][j].getClass() == King.class) {
                        King king = (King) chessBoard[i][j];
                        if (king.iswhite()) {
                            System.out.print("[W"+king.getToken()+"] ");
                        } else {
                            System.out.print("[B"+king.getToken()+"] ");
                        }
                    }
                    else if (chessBoard[i][j].getClass() == Knight.class) {
                        Knight knight = (Knight) chessBoard[i][j];
                        if (knight.iswhite()) {
                            System.out.print("[W"+knight.getToken()+"] ");
                        } else {
                            System.out.print("[B"+knight.getToken()+"] ");
                        }
                    }
                    else if (chessBoard[i][j].getClass() == Queen.class) {
                        Queen queen = (Queen) chessBoard[i][j];
                        if (queen.iswhite()) {
                            System.out.print("[W" + queen.getToken()+"] ");
                        } else {
                            System.out.print("[B" + queen.getToken()+"] ");
                        }
                    }
                    else if (chessBoard[i][j].getClass() == Pawn.class) {
                        Pawn pawn = (Pawn) chessBoard[i][j];
                        if (pawn.iswhite()) {
                            System.out.print("[W" + pawn.getToken()+"] ");
                        } else {
                            System.out.print("[B" + pawn.getToken()+"] ");
                        }
                    }
                    else if (chessBoard[i][j].getClass() == Rock.class) {
                        Rock rock = (Rock) chessBoard[i][j];
                        if (rock.iswhite()) {
                            System.out.print("[W" + rock.getToken()+"] ");
                        } else {
                            System.out.print("[B" + rock.getToken()+"] ");
                        }
                    }

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

    /*public tryMove(int[] movearray) {

    ArrayList<Integer> path = Figur.path(movearray);

    if(chessBoard[movearray[2],movearray[3]].iswhite() == chessBoard[movearray[0],movearray[1]].iswhite()){
        return false;
    }
    int x = path.size();
    for(int i=0; i<x; i +=2){
        if(Board.getFiguresArray(path.get(i),path.get(i+1)) != null){
            return false;
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

     */

}
