import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        //START Init Players
        Player[] players = game.setupPlayers();
        //END Init Players

        //START Init Board
        int boardsize = game.inputBoardsize();
        Board board = new Board(boardsize);
        Square[] squares = board.initSquares();
        //END Init Board

        //START Run Game
        game.playGame(board,squares,players);
        //END Run Game
    }

}


