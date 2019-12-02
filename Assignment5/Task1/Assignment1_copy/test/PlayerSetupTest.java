package test;

import main.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;


public class PlayerSetupTest implements Runnable {

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
     * test for restriction of amount fo players, lower limit
     */
   @Test
   public void testInputPlayerAmountLower() {
        thread = new Thread(this);
        String input1 = "9"; //should be <= 4 and >= 2
        InputStream in2 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in2);
        long start_time = System.currentTimeMillis();
        thread.start();
        long end_time = System.currentTimeMillis();
        while (end_time-start_time < 10){
            end_time = System.currentTimeMillis();
        }
        thread.interrupt();
        thread = null;
        String outputSTR = outContent.toString();
       String outputSTR2 = outContent.toString();
        Assert.assertTrue("expected 'Choose 2, 3 or 4 players'",outputSTR2.matches("(.*)(?s).*[\\n\\r].*(.*)\\nChoose 2, 3 or 4 players\\n(.*)(?s).*[\\n\\r].*(.*)"));
    }

    /**
     * using threading for input testing
     */
    @Override
    public void run() {
        running = true;
        playerSetup.setup();
        running = false;
    }
}
