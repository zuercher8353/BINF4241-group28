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
        playerNames[1] = "test1";
        playerNames[2] = "test2";
        scoreToWin = 20;
        game = new Game(nrOfPlayers, playerNames, scoreToWin);
    }

    /**
     * testing the functionality of the Wildcard Draw4, s.t. the other player has 4 more cards in his hands (initially 0)
     */
    public void testWildCardDraw4 {
        ArrayList<Players> players = game.returnPlayer();
        Player player1 = players[1];
        Player player2 =  players[2];
        Cards wildCard = new WildCard("WildDraw4",4);
        player1.addHandCard(wildCard);
        game.playCardIfLegal("BlackWildDraw4",player1);
        player1.playCard(wildCard);
        Assert.assertEqual(4,player2.nrOfCards);
    }

    /**
     * testing the functionality of the Wildcard color change, s.t. the other player can only play a card of the set color
     */
    public void testWildCardDrawColor {
        Cards newCard = new Cards("Green",5);
        ArrayList<Players> players = game.returnPlayer();
        Player player1 = players[1];
        Player player2 =  players[2];

        game.addCardToPlayedPile(newCard);
        Cards wildCard = new WildCard("Wild",0);
        player1.addHandCard(wildCard);
        game.playCardIfLegal("BlackWild",player1);
        player1.playCard(wildCard);
        Assert.assertFalse(game.playCardIfLegal("Blue6",player2))
        Assert.assertTrue(game.playCardIfLegal("Red7",player2))
    }

    /**
     * testing the DrawTwo functionality, s.t. the other player has two more cards
     */
    public void testDrawTwo() {
        Cards newCard = new Cards("Red",5);
        ArrayList<Players> players = game.returnPlayer();
        Player player1 = players[1];
        Player player2 =  players[2];

        game.addCardToPlayedPile(newCard);
        Cards drawTwo = new DrawTwo("Red");
        player1.addHandCard(drawTwo);
        game.playCardIfLegal("RedDraw2",player1);
        player1.playCard(drawTwo);
        Assert.assertNotEqual((0,player2.nrOfHandCards))
        Assert.assertEqual(2,player2.nrOfHandCards)
    }
}