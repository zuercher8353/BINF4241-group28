
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
        game = new Game(nrOfPlayers, playerNames, scoreToWin);
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
     * Testing playCardIfLegal() and addCardToPlayedPile() which is used by playCardIfLegal().
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
     * Testing playerShoutedUno() together with playCardIfLegal("cardnameUno")
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
        Assert.assertFalse(game.playCardIfLegal("Green2Uno", player2));
        Assert.assertFalse(game.playerShoutedUno(player2));
    }

    /**
     * Testing getCardNrDrawPile(), ShufflePlayedToDraw(), this should shuffle all Cards of the PlayedPile besides the last played card to the DrawPile
     */
    @Test
    public void testShufflePlayedToDraw(){

        Cards card = new NumberCard("Blue", 1);
        int beforeShuffle = game.getCardNrDrawPile();
        game.addCardToPlayedPile(card);
        game.addCardToPlayedPile(card);
        game.ShufflePlayedToDraw();
        int afterShuffle = game.getCardNrDrawPile();
        Assert.assertEquals(beforeShuffle + 2, afterShuffle);

    }
    /**
     * Testing HandoutCards, which should handout 7 cards to all players
     */
    @Test
    public void testHandoutCards(){
        ArrayList<Player> players= game.returnPlayers();
        Player gamePlayer1 = players.remove();
        Player gamePlayer2 = players.remove();
        Assert.assertEquals(7, gamePlayer1.nrOfHandCards);
        Assert.assertEquals(7, gamePlayer2.nrOfHandCards);
    }
    /**
     * testing ChangeDirection and returnDirectionNextPlayer
     */
    @Test
    public void testSwitchDirection(){
        game.changeDirection(2);
        Assert.assertEquals(2, returnDirectionNextPlayer());
    }

    /**
     *  Testing gameRoundOver and assignScore, by playing all cards and then checking if gameRound over and score changed
     */
    @Test
    public void testGameRoundOver(){
        Assert.assertFalse(game.gameRoundOver());
        ArrayList<Player> players= game.returnPlayers();
        Player gamePlayer1 = players.remove();
        ArrayList<Cards> = gamePlayer1.returnHandCards();
        for (Cards card: ArrayList<Cards>) {
            gamePlayer1.playCard(card);
        }
        int scoreBeforeRoundOver = gamePlayer1.getScore();
        //check if gameRound over
        Assert.assertTrue(game.gameRoundOver());
        Assert.assertNotEquals(scoreBeforeRoundOver, gamePlayer1.getScore());
    }
    /**
     *  Testing DrawCards(), by drawing 1 and 4 cards
     */
    @Test
    public void testDrawCards(){
        int nrOfCardsBefore = player1.nrOfHandCards();
        game.drawCards(1, player1);
        Assert.assertEquals(1, (player1.nrOfHandCards()-nrOfCardsBefore));
        int nrOfCardsBefore2 = player2.nrOfHandCards();
        game.drawCards(4, player2);
        Assert.assertEquals(4, (player2.nrOfHandCards()-nrOfCardsBefore2));
    }
    /**
     * Testing gameRunning(), by increasing the score of a player so that it equals the scoreToWin
     */
    @Test
    public void testGameRunning(){
        Assert.assertTrue(game.gameRunning());
        ArrayList<Player> players= game.returnPlayers();
        Player gamePlayer1 = players.remove();
        gamePlayer1.updateScore(20);
        Assert.assertFalse(game.gameRunning());
    }





    /**
     * Test the getter method of the Handcards of a player, after adding HandCards. must return the correct ArrayList of cards
     */
    @Test
    public void testReturnHandCards() {

        Cards newCard1 = new Cards("Red",5);
        Cards newCard2 = new Cards("Blue",4);
        Cards newCard3 = new Cards("Green",3);

        ArrayList<Cards> newcards = new ArrayList<Cards>();
        newcards.add(newCard1);
        newcards.add(newCard2);
        newcards.add(newCard3);

        ArrayList<Cards> newcards2 = new ArrayList<Cards>();
        newcards.add(newCard1);
        newcards.add(newCard2);

        ArrayList<Player> players = game.returnPlayers();
        Player player2 = players.remove(1);
        Player player1 =  players.remove(0);

        player1.createHandcards;

        player1.addHandCard(newCard1);
        player1.addHandCard(newCard2);
        player1.addHandCard(newCard3);

        player2.addHandCard(newCard1);
        player2.addHandCard(newCard2);

        Assert.assertEquals(newcards,game.returnHandCards(player1));
        Assert.assertEquals(newcards2,game.returnHandCards(player2));
        Assert.assertTrue(game.returnHandCards(player1)instanceof ArrayList<Cards>);
    }

    /**
     * test the returnPlayers method of the Game class, whether it returns the correct type and the correct player names
     */
    @Test
    public void testReturnPlayers() {

        Assert.assertTrue(game.returnPlayers()instanceof ArrayList<Player>);

        ArrayList<Player> players = game.returnPlayer();
        String name1 = players.remove(0).returnName();
        String name2 = players.remove(1).returnName();

        Assert.assertEquals("test1",name1);
        Assert.assertEquals("test2",name2);
    }

    /**
     * Testing CardDrawPileToPlayPile(), by using getCardNrDrawPile() and shufflePlayedToDraw()
     */

    @Test
    public void testCardDrawPileToPlayPile() {
        game.shufflePlayedToDraw();
        int initValue = game.getCardNrDrawPile();
        game.moveCardDrawPileToPlayPile();
        Assert.assertEquals(initValue -1,game.getCardNrDrawPile());

        game.shufflePlayedToDraw();
        Assert.assertEquals(initValue,game.getCardNrDrawPile());
    }
}
