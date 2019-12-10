package Test;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.*;

import java.util.ArrayList;

/**
 * Test Class to test the functionality of the Cards interface
 */
public class TestCards {

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
        playerNames[0] = "test1";
        playerNames[1] = "test2";
        scoreToWin = 20;
        game = new Game(nrOfPlayers, playerNames, scoreToWin);
    }

    /**
     * testing the functionality of the Wildcard Draw4, s.t. the other player has 4 more cards in his hands (initially 0)
     */
    public void testWildCardDraw4() {
        ArrayList<Player> players = game.returnPlayer();
        Player player2 = players.remove(1);
        Player player1 =  players.remove(0);
        Cards wildCard = new WildCard("WildDraw4",4);
        player1.addHandCard(wildCard);
        game.playCardIfLegal("BlackWildDraw4",player1);
        player1.playCard(wildCard);
        Assert.assertEquals(4,player2.nrOfHandCards());
    }

    /**
     * testing the functionality of the Wildcard color change, s.t. the other player can only play a card of the set color
     */
    public void testWildCardDrawColor() {
        NumberCard newCard = new NumberCard("Green",5);
        ArrayList<Player> players = game.returnPlayer();
        Player player2 = players.remove(1);
        Player player1 =  players.remove(0);

        game.addCardToPlayedPile(newCard);
        WildCard wildCard = new WildCard("Wild",0);
        player1.addHandCard(wildCard);
        game.playCardIfLegal("BlackWild",player1);
        player1.playCard(wildCard);
        Assert.assertFalse(game.playCardIfLegal("Blue6",player2));
        Assert.assertTrue(game.playCardIfLegal("Red7",player2));
    }

    /**
     * testing the DrawTwo functionality, s.t. the other player has two more cards
     */
    public void testDrawTwo() {
        NumberCard newCard = new NumberCard("Red",5);
        ArrayList<Player> players = game.returnPlayer();
        Player player2 = players.remove(1);
        Player player1 =  players.remove(0);

        game.addCardToPlayedPile(newCard);
        DrawTwo drawTwo = new DrawTwo("Red");
        player1.addHandCard(drawTwo);
        game.playCardIfLegal("RedDraw2",player1);
        player1.playCard(drawTwo);
        Assert.assertNotEquals(0,player2.nrOfHandCards());
        Assert.assertEquals(2,player2.nrOfHandCards());
    }

    /**
     * testing the funcitonality of the Skip Card
     */
    public void testSkip() {
        NumberCard newCard = new NumberCard("Red",5);
        ArrayList<Player> players = game.returnPlayer();
        Player player2 = players.remove(1);
        Player player1 =  players.remove(0);

        game.addCardToPlayedPile(newCard);
        ActionCard skipCard = new ActionCard("Red",2);
        game.playCardIfLegal("RedSkip",player1);
        player1.playCard(skipCard);
        Assert.assertEquals(2,game.returnDirectionNextPlayer());
    }

    /**
     * testing the Reverse Card, which always has direction -1, the game should return the direciton of -1
     */
    @Test
    public void testReverse() {
        NumberCard newCard = new NumberCard("Red",5);
        ArrayList<Player> players = game.returnPlayer();
        Player player2 = players.remove(1);
        Player player1 =  players.remove(0);

        game.addCardToPlayedPile(newCard);
        ActionCard reverseCard = new ActionCard("Red",-1);
        game.playCardIfLegal("RedSkip",player1);
        player1.playCard(reverseCard);
        Assert.assertEquals(-1,game.returnDirectionNextPlayer());

        ActionCard reverseCard2 = new ActionCard("Red",-1);
        player1.playCard(reverseCard2);
        game.playCardIfLegal("RedSkip",player1);
        Assert.assertEquals(1,game.returnDirectionNextPlayer());
    }
}
