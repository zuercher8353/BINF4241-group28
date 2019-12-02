import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class GameTest {

    @BeforeEach
    public void setup() {
        game = new Game();

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

}
