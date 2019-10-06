import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Game Game = new Game();

        //START Init Players
        Player[] players = Game.setupPlayers();
        //END Init Players

        //START Init Board
        int boardsize = Game.inputBoardsize();
        Board board = new Board(boardsize);
        Square[] squares = board.initSquares();
        //END Init Board

        //START Run Game
        Game.playGame(board,squares,players);
        //END Run Game
    }

}


