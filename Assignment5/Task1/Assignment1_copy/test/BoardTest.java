package test;

import main.*;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class BoardTest {
    private int boardsize = 8;
    private Board board;
    private Die die;
    private Game game;


    @Before
    public void setup() {
        game = new Game();
        board = new Board(boardsize);
        die = new Die();
    }

    @Test
    public void testBoardSize() {
        int newBoardsize = 9;
        Board newBoard = new Board(newBoardsize);
        //check for length of squares array
        Assert.assertEquals(9, newBoard.initSquares().length);
        Assert.assertEquals(newBoard.getBoardsize(), newBoardsize);
        Assert.assertNotEquals(newBoard.getBoardsize(), board.getBoardsize());
    }

 /*   @Test
    public void testBoardSizeInput() throws Exception{
        //Test minimal board size
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("randSTR".getBytes());
        System.setIn(in);
        Assert.assertEquals("Choose between 10 and 100 squares\n",game.inputBoardsize());
}*/
}
