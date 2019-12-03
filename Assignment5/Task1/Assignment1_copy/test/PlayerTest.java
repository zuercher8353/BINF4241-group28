package test;

import main.*;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
/**
 * Test class for testing the Player Class
 */
class PlayerTest {
    private int boardsize = 20;
    private Player player1;
    private Player player2;
    private Board board1;
    private Player[] players;
    private Square[] squares1;
    private Square[] squares2;

    /**
     * initial setup
     */
    @BeforeEach
    void setup() {
        player1 = new Player("janosch");
        player2 = new Player("jonas");
        board1 = new Board(boardsize);
        players = new Player[]{player1, player2};
        squares1 = board1.initSquares();
        squares2 = board1.initSquares();
}
    /**
     * Test whether the input name is actually set
     */
    @Test
    void testPlayerName() {
        //check if playername is set correctly
        Assert.assertEquals("janosch",player1.getName());
        Player newPlayer = new Player("janosch");
        //check two players having similar names, should be okay
        Assert.assertEquals(player1.getName(), newPlayer.getName());
    }

    /**
     * Let a player finish with overhead, position should still be on end field
     */
    @Test
    void testPlayerFinishOver() {
        Player newPlayer = new Player("randomString");
        Board newBoard = new Board(boardsize);
        Square[] newSquares = board1.initSquares();
        int moveNumber = 6; //move to a position where no snake/ladder is

        //initially set player close to end
        newPlayer.updatePosition(boardsize - moveNumber,newSquares,newBoard);

        //move exactly to end
        newPlayer.updatePosition(2*moveNumber,newSquares,newBoard);
        Assert.assertEquals(boardsize-1,newPlayer.getPosition()); //substract one bc array starts at 0
    }

    /**
     * Let on player move by rolling the die, after both players have been set on the same position
     * Afterwards their position should not be equal
     */
    @Test
    void testTakeTurn() {
        //squares array should be different after moving one player
        player1.takeTurn(squares1,board1,players);
        Assert.assertNotEquals(squares1[player1.getPosition()],squares2[player1.getPosition()]);
    }

    /**
     * Test if a player behaves correctly when encountering a ladder or a snake, test method getPosition
     * Test getEnd method of Snake and Ladder
     */
    @Test
    void testUpdatePositionCase() {
        Player newPlayer = new Player("xx");
        Square[] newSquares = board1.initSquares();
        int initialposition = newPlayer.getPosition();
        int moveNumber = 10; //move to a position where no snake/ladder is
        newPlayer.updatePosition(moveNumber,newSquares,board1);

        //if there is a Ladder at the target position
        if(newSquares[initialposition+moveNumber] instanceof Ladder) {
            Assert.assertEquals(newSquares[initialposition+moveNumber].getEnd(),newPlayer.getPosition());
        }
        //if there is a Snake at the target position
        else if(newSquares[initialposition+moveNumber] instanceof Snake) {
            Assert.assertEquals(newSquares[initialposition+moveNumber].getEnd(),newPlayer.getPosition());
        }
        //if there is a simple Square at the target position
        else Assert.assertEquals(initialposition+moveNumber,newPlayer.getPosition());
    }

    /**
     * Let a player finish exaclty and test his position
     */
    @Test
    void testPlayerFinishExact() {
        Player newPlayer = new Player("randomString");
        Board newBoard = new Board(boardsize);
        Square[] newSquares = board1.initSquares();
        int moveNumber = 6; //move to a position where no snake/ladder is

        //initially set player close to end
        newPlayer.updatePosition(boardsize - moveNumber,newSquares,newBoard);

        //move exactly to end
        newPlayer.updatePosition(moveNumber,newSquares,newBoard);
        Assert.assertEquals(boardsize-1,newPlayer.getPosition()); //substract one bc array starts at 0
    }

    /**
     * Test case when a player moves to a field which is occupied, should return to start
     */
    @Test
    void testPlayersSamePosition() {
        Player newPlayer1 = new Player("randomString");
        Player newPlayer2 = new Player("randomString2");
        Board newBoard = new Board(boardsize);
        Square[] newSquares = board1.initSquares();
        int moveNumber = 6; //move to a position where no snake/ladder is

        //initially set player close to end
        newPlayer1.updatePosition(moveNumber,newSquares,newBoard);
        newPlayer2.updatePosition(moveNumber,newSquares,newBoard);

        //Players position should not be equal, since field is occupied
        Assert.assertNotEquals(newPlayer1.getPosition(),newPlayer2.getPosition());
        Assert.assertEquals(0,newPlayer2.getPosition());
    }

    /**
     * Test the die such that no result is > 6 and < 1
     */
    @Test
    void testDie() {
        for(int i=0;i<=100;i++){ //how to statistically test
            Assert.assertTrue(1 <= Die.roll());
            Assert.assertTrue(6 >= Die.roll());
        }
    }

}
