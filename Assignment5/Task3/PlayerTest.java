import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

public class PlayerTest {
    Player player1;
    String name = "test";

    @BeforeEach
    public void setup() {
        player1 = new Player(name);

    }


    /**
     * test of setting a player name and getting a player name
     */
    @Test
    public void testPlayerName() {
        //check if playername is set correctly
        Assert.assertEquals(player1.returnName(), "test");
        Player newPlayer = new Player("test");
        //check two players having similar names, should be okay
        Assert.assertEquals(player1.returnName(), newPlayer.returnName());
    }


    /**
     * testing the score updating
     */
    @Test
    public void testScore() {
        //check if score is set to zero, when initializized
        Assert.assertEquals(player1.getscore(), 0);
        //check if increasing of score works
        player1.updateScore(10);
        Assert.assertEquals(10, player1.getscore());

    }

    /**
     * testing the number of cards in the players hand after adding them
     */
    @Test
    public void testNrOFHandCards() {
        player1.createHandcards
        Cards card1 = new NumberCard("Red", 6);
        Cards card2 = new NumberCard("Blue", 4);
        Cards card3 = new NumberCard("Green", 2);
        player1.addHandCard(card1);
        player1.addHandCard(card2);
        player1.addHandCard(card3);
        Assert.assertTrue(player1.nrOfHandCards() == 3);
        player1.playCard(card1);
        Assert.assertTrue(player1.nrOfHandCards() == 2);
    }

    /**
     * test whether returnHandCards returns an ArrayList of Cards and if it is equal
     * to the added cards as an array, also after player a card
     */
    @Test
    public void testReturnHandCards() {
        player1.createHandcards;
        Cards card1 = new NumberCard("Red", 6);
        Cards card2 = new NumberCard("Blue", 4);
        Cards card3 = new NumberCard("Green", 2);
        ArrayList<Cards> cardsList = ArrayList < Cards > [card1, card2, card3];
        ArrayList<Cards> cardsList2 = ArrayList < Cards > {card1, card2};
        player1.addHandCard(card1);
        player1.addHandCard(card2);
        player1.addHandCard(card3):
        Assert.assertTrue(player1.returnHandCards instanceof ArrayList<Cards>);
        Assert.assertTrue(player1.returnHandCards == cardsList);
        player1.playCard(card3);
        Assert.assertTrue(player1.returnHandCards == cardsList2);
    }

    /**
     * test the score of the player, which is initially set to zero
     */
    @Test
    public void testPlayerScore() {
        player1.updateScore(2);
        Assert.assertEquals(2, player1.getScore);
    }


}
