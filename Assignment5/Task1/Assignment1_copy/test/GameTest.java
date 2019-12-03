package test;

import main.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


public class GameTest implements Runnable {

    private boolean running = false;
    private Thread thread;

    Game game;
    Board board;
    Die die;
    PlayerSetup playerSetup;
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
        playerSetup = new PlayerSetup();
        player1 = new Player("janosch");
        player2 = new Player("jonas");
        players = new Player[]{player1, player2};
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    /**
     * Test for final string when game ends
     */
    @Test
    void testGameEndOutput() {
        game.playGame(board, board.initSquares(), players);
        String outputSTR = outContent.toString();
        Assert.assertTrue("last line should contain 'GAME ENDED'", outputSTR.matches("(.*)(?s).*[\\n\\r].*(.*)GAME ENDED(.*)"));
    }

    /**
     * Test such that there is one player on the last square when the game ended
     */
    @Test
    void testGameEndSquare() {
        Square[] squares = board.initSquares();
        game.playGame(board, squares, players);
        int p1pos = player1.getPosition();
        int p2pos = player2.getPosition();
        Assert.assertTrue(p1pos == boardsize - 1 || p2pos == boardsize - 1);
    }

    /**
     * test upper limit of boardsize input
     */
    @Test
    void testInputBoardsizeOver() {
        thread = new Thread(this);
        String input = "101"; //should be <= 100
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        long start_time = System.currentTimeMillis();
        thread.start();
        long end_time = System.currentTimeMillis();
        while (end_time-start_time < 1000){
            end_time = System.currentTimeMillis();
        }
        thread.interrupt();
        thread = null;
        String outputSTR = outContent.toString();
        Assert.assertTrue("expected 'Invalid input'",outputSTR.matches("(.*)(?s).*[\\n\\r].*(.*)Invalid input\n\n(.*)"));
    }

    /**
     * test lower limit of boardsize input
     */
    @Test
    void testInputBoardsizeLower() {
        thread = new Thread(this);
        String input = "9"; //should be <= 100 and > 10
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        long start_time = System.currentTimeMillis();
        thread.start();
        long end_time = System.currentTimeMillis();
        while (end_time-start_time < 1000){
            end_time = System.currentTimeMillis();
        }
        thread.interrupt();
        thread = null;
        String outputSTR = outContent.toString();
        Assert.assertTrue("expected 'Choose between 10 and 100 squares'",outputSTR.matches("(.*)(?s).*[\\n\\r].*(.*)Invalid input\n\n(.*)"));
    }


    /**
     * using threading for input testing
     */
    @Override
    public void run() {
        running = true;
        game.inputBoardsize();
        running = false;
    }

}
