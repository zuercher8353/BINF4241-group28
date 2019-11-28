package test;

import main.Board;
import main.Die;
import main.Player;
import main.Square;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

class PlayerTest {
    private int boardsize = 20;
    private Player player1;
    private Player player2;
    private Board board1;
    private Player[] players;

    @BeforeEach
    void setup() {
        player1 = new Player("janosch");
        player2 = new Player("jonas");
        board1 = new Board(boardsize);
        players = new Player[]{player1, player2};
}

    @Test
    void testPlayerName() {
        Assert.assertEquals(player1.getName(),"janosch");
        Player newPlayer = new Player("janosch");
        Assert.assertEquals(player1.getName(), newPlayer.getName());
    }

    @Test
    void testTakeTurn() {
        Square[] squares1 = board1.initSquares();
        player1.takeTurn(squares1,board1,players);
        System.out.println(squares1[player1.getPosition()].getClass());
        //Assert.assertEquals(squares1[player1.getPosition()],player1.getPosition());
    }

    @Test
    void testDie() {
        for(int i=0;i<=100;i++){ //how to statistically test
            Assert.assertTrue(1 <= Die.roll());
            Assert.assertTrue(6 >= Die.roll());
        }
    }

}
