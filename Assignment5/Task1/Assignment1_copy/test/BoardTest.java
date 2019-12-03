package test;

import com.sun.source.tree.AssertTree;
import main.*;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
/**
 * Test Class for testing the Board.
 * The {@link Board#printBoardArray printBoard} Method is not being tested.
 */
public class BoardTest {

    private int boardsize = 21;
    private Board board;
    private Die die;
    private Game game;
    private Player player1;

    @Before
    public void setup() {
        game = new Game();
        board = new Board(boardsize);
        die = new Die();
        player1 = new Player("aName");
    }


    /**
     * test the board size with a numeric input as well as test the size of the squares array
     * after the initiallization of the squares. Compare the new board to another board
     * with a different numeric input.
     * Cannot test for edge cases since the {@link Game#inputBoardsize() Game Class} is handling the size restriction.
     */
    @Test
    public void testBoardSize() {
        int newBoardsize = 9;
        Board newBoard = new Board(newBoardsize);
        //check for length of squares array
        Assert.assertEquals(9, newBoard.initSquares().length);
        Assert.assertEquals(newBoard.getBoardsize(), newBoardsize);
        Assert.assertNotEquals(newBoard.getBoardsize(), board.getBoardsize());
    }

    /**
     * Test positions of ladders (the positions are fixed according to the boardsize)
     * every 5th starting from 1
     */
    @Test
    public void testLadderPositions() {
        Square[] squares = board.initSquares();
        Assert.assertTrue("Square 1 should be a ladder", squares[1]instanceof Ladder);
        Assert.assertTrue("Square 1 should be a ladder", squares[16]instanceof Ladder);
    }

    /**
     * Test positions of snakes (the positions are fixed according to the boardsize)
     * every 5th starting from 5, while the last square can neither be a ladder nor a square
     */
    @Test
    public void testSnakePositions() {
        Square[] squares = board.initSquares();
        Assert.assertTrue("Square 1 should be a ladder", squares[5]instanceof Snake);
        Assert.assertFalse("Square 1 should be a ladder", squares[20]instanceof Snake);
    }

    /**
    * Test if the getOccupied method is working correctly with Laddder and Snake Cases
     */
    @Test
    public void testSquareOccupied() {
        int newBoardsize = 20;
        Board newBoard = new Board(newBoardsize);
        Square[] squares = board.initSquares();
        player1.updatePosition(7,squares,board); //normal case
        Assert.assertTrue(squares[7].getOccupied());
        player1.updatePosition(3,squares,board); //snake
        Assert.assertFalse(squares[10].getOccupied());
        Assert.assertTrue(squares[7].getOccupied());
        player1.updatePosition(4,squares,board);
        Assert.assertFalse(squares[11].getOccupied());
        Assert.assertTrue(squares[14].getOccupied()); //snake
    }
}
