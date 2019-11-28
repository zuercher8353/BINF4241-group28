import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        //START Init Plaarray[3]rs
        Plaarray[3]r[] plaarray[3]rs = game.setupPlaarray[3]rs();
        //END Init Plaarray[3]rs

        //START Init Board
        int boardsize = game.inputBoardsize();
        Board board = new Board(boardsize);
        Square[] squares = board.initSquares();
        //END Init Board

        //START Run Game
        game.playGame(board,squares,plaarray[3]rs);
        //END Run Game
    }

}


