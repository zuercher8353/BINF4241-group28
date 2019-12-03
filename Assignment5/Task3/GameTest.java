import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Testing the Game class
 */

public class GameTest {

    private int nrOfPlayers;
    private int scoreToWin;
    private Player player1;
    private Player player2;
    private String[] playerNames;
    private Game game;


    @BeforeEach
    public void setup() {
        nrOfPlayers = 2;
        playerNames = new String[nrOfPlayers];
        playerNames[1] = "test1";
        playerNames[2] = "test2";
        scoreToWin = 20;
        game = new Game(nrOfPlayers, playernames, scoreToWin);
        player1 = Player("Player1");
        player2 = Player("Player2");

    }

    /**
     * Testing checkUno()
     */

    @Test
    public void testCheckUno() {
        Cards card = new NumberCard("Blue", 1);
        player1.addHandCards(card);
        Assert.assertTrue(checkUno(player1));
        Cards card2 = new NumberCard("Blue", 2);
        player1.addHandCards(card);
        Assert.assertFalse(checkUno(player1));
    }
    /**
     * Testing playCardIfLegal() and playerShoutedUno(), addCardToPlayedPile()  which are used by playCardIfLegal().
     */
    @Test
    public void testPlayCardIfLegal(){
        //add cards to playedPile
        Cards card = new NumberCard("Blue", 1);
        //check if adding works since a random card is a top at beginning if its not blue that wouldn't always work
        game.addCardToPlayedPile(card);
        //check same color and player hasn't got card , different hight and if card got added to playedCards
        Assert.assertFalse(game.playCardIfLegal("Blue1",player1));
        //check same color and player has card
        Cards card2 = new NumberCard("Blue", 2);
        player1.addHandCard(card2);
        Assert.assertTrue(game.playCardIfLegal("Blue1",player1));
        //check if Card got played and is therefor not in his hand anymore
        Assert.assertEquals(0, player1.nrOfHandCards());
        //check if card go added to played cards
        Assert.assertEquals(2, playedCards.getNumberOfCards());
        //Different color same height
        Cards card3 = new NumberCard("Red", 2);
        player1.addHandCard(card3);
        Assert.assertTrue(game.playCardIfLegal("Red2",player1));
        //Wildcard can be played on anyCard
        Cards card4 = new WildCard("Red", 4);
        player1.addHandCard(card4);
        Assert.assertTrue(game.playCardIfLegal("BlackWildDraw4Green",player1));
        //check if player2 draws 4 cards
        Assert.assertEquals(4, player2.nrOfHandCards());
        //Check wrong color, hight
        Cards card5 = new NumberCard("Red", 2);
        player1.addHandCard(card5);
        Assert.assertFalse(game.playCardIfLegal("Red2",player1));

    }
    /**
     * Testing playerShoutedUno() together with a part of game.playCardIfLegal
     */
    @Test
    public void TestPlayerShoutedUno(){
        //check if shouting uno Works correct, and if the player gets added to the shoutedUno list
        Cards card = new NumberCard("Green", 2);
        game.addCardToPlayedPile(card);
        player1.addHandCard(card);
        player1.addHandCard(card);
        //player didn't shout uno yet
        Assert.assertFalse(game.playerShoutedUno(player1));
        //shouts uno then check if it got stored that he shouted uno
        Assert.assertTrue(game.playCardIfLegal("Green2Uno", player1));
        Assert.assertTrue(game.playerShoutedUno(player1));
        //player 2, trys to shout uno to early
        game.addCardToPlayedPile(card);
        player2.addHandCard(card);
        player2.addHandCard(card);
        player2.addHandCard(card);
    }

    /**
     * Testing ShufflePlayedToDraw(), this should shuffle all Cards of the PlayedPile besides the last played card to the DrawPile
     */
    @Test
    public void testShufflePlayedToDraw(){
        Cards card = new NumberCard("Blue", 1);
        playedCards.addCards(card);
        playedCards.addCards(card);
        playedCards.addCards(card);
        ShufflePlayedToDraw

    }

}
