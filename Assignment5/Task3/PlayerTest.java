import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

/**
 * In this testclass the player class is tested
 */
public class PlayerTest {
    Player player1;
    String name = "test";


    @BeforeEach
    public void setup() {
        player1 = new Player(name);
    }

    /**
     * Testing the returnName() method and the init of the name
     */

    @Test
    void testPlayerName() {
        //check if playername is set correctly
        Assert.assertEquals(player1.returnName(),"test");
        Player newPlayer = new Player("test");
        //check two players having similar names, should be okay
        Assert.assertEquals(player1.returnName(), newPlayer.returnName());
    }


    /**
     * Testing the getScore() and the upDateScore() method
     */
    @Test
    void testScore(){
        //check if score is set to zero, when initializized
        Assert.assertEquals(0, player1.getscore());
        //check if increasing of score works
        player1.updateScore(10);
        Assert.assertEquals(10,player1.getscore());

    }



}
