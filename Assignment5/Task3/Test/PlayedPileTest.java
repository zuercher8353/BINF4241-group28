package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.*;

import java.util.ArrayList;

/**
 * Testing the PlayedPile Class
 */
public class PlayedPileTest {

        private PlayedPile playedPile = new PlayedPile();

        @Before
        public void setup(){
            playedPile = new PlayedPile();
        }


        /**
         * This test checks if addCards() works
         */
        @Test
        public void nrOfCards(){
            Cards c1 = new NumberCard("blue", 1);
            Cards c2 = new NumberCard("blue", 2);
            Cards c3 = new NumberCard("green",7);
            Cards c4 = new NumberCard("red", 5);

            playedPile.addCards(c1);
            playedPile.addCards(c2);
            playedPile.addCards(c3);
            playedPile.addCards(c4);

            Assert.assertEquals(4, playedPile.getNrOfCards());
        }


        /**
         * this test checks the method isEmpty()
         */
        @Test
        public void isEmpty(){
            Assert.assertTrue(playedPile.isEmpty());
            Assert.assertEquals(0, playedPile.getNrOfCards());
            Cards c1 = new NumberCard("blue", 1);
            Cards c2 = new NumberCard("blue", 2);


            playedPile.addCards(c1);
            playedPile.addCards(c2);

            Assert.assertEquals(2, playedPile.getNrOfCards());
            Assert.assertFalse(playedPile.isEmpty());


        }

        /**
         * this test checks if removeCards() works
         */
        @Test
        public void removeCardsWorks(){
            Cards c1 = new NumberCard("blue", 1);
            Cards c2 = new NumberCard("blue", 2);
            Cards c3 = new NumberCard("green",7);
            Cards c4 = new NumberCard("red", 5);

            playedPile.addCards(c1);
            playedPile.addCards(c2);
            playedPile.addCards(c3);
            playedPile.addCards(c4);

            ArrayList<Cards> played = new ArrayList<>() {{
                add(c4);
            }};

            ArrayList<Cards> removed = playedPile.removeCard();

            Assert.assertEquals(1, playedPile.getNrOfCards());

            Assert.assertEquals(played, removed);
        }


        /**
         * this test checks if lastPlayedCard() works
         */
        @Test
        public void getCards(){
            Cards c1 = new NumberCard("blue", 1);
            Cards c2 = new NumberCard("blue", 2);
            Cards c3 = new NumberCard("green",7);
            Cards c4 = new NumberCard("red", 5);

            playedPile.addCards(c1);
            playedPile.addCards(c2);
            playedPile.addCards(c3);
            playedPile.addCards(c4);


            Assert.assertEquals(c4, playedPile.lastPlayedCard());
        }

}
