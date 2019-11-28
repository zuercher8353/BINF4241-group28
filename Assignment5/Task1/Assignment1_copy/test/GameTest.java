package test;

import main.Board;
import main.Die;
import main.Game;
import main.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

class GameTest {
    Game game;
    Board board;
    Die die;
    int boardsize = 20;
    private Player player1;
    private Player player2;
    private Player[] players;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setup() {
        game = new Game();
        board = new Board(boardsize);
        die = new Die();
        Game game = new Game();
        player1 = new Player("janosch");
        player2 = new Player("jonas");
        players = new Player[]{player1, player2};
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    void testPlayGame() {
        game.playGame(board, board.initSquares(), players);
        String outputSTR = outContent.toString();
        Assert.assertTrue(Pattern.matches(outputSTR.matches("(.*)geeks(.*)"));
    }
}
