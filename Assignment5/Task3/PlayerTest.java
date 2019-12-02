import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

public class PlayerTest {
    Player player1;
    String name = "test";

    @BeforeEach
    public void setup() {
        player1 = new Player(name);
    }

    @Test
    void testPlayerName() {
        //check if playername is set correctly
        Assert.assertEquals(player1.returnName(),"test");
        Player newPlayer = new Player("test");
        //check two players having similar names, should be okay
        Assert.assertEquals(player1.returnName(), newPlayer.returnName());
    }

    @Test
    void testScore(){
        //check if score is set to zero, when initializized
        Assert.assertEquals(player1.getscore(), 0);
        //check if increasing of score works
        player1.updateScore(10);
        Assert.assertEquals(player1.getscore(), 10);

    }


}
