import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class PlayedPileTest {

        PlayedPile playedPile = new PlayedPile();

        @Before
        public void setup(){
            playedPile = new PlayedPile();
        }


        /**
         * This test checks if addCards() works
         */
        @Test
        public void nrOfCards(){
            Cards c1 = new Cards(blue);
            Cards c2 = new Cards(blue);
            Cards c3 = new Cards(green);
            Cards c4 = new Cards(red);

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
            Cards c1 = new Cards(blue);
            Cards c2 = new Cards(blue);

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
            Cards c1 = new Cards(blue);
            Cards c2 = new Cards(blue);
            Cards c3 = new Cards(green);
            Cards c4 = new Cards(red);

            playedPile.addCards(c1);
            playedPile.addCards(c2);
            playedPile.addCards(c3);
            playedPile.addCards(c4);

            ArrayList<Cards> played = new ArrayList<>() {{
                add(c4);
            }};

            Cards removed = playedPile.removeCards();

            Assert.assertEquals(1, playedPile.getNrOfCards());

            Assert.assertEquals(played, removed);
        }


        /**
         * this test checks if lastPlayedCard() works
         */
        @Test
        public void getCards(){
            Cards c1 = new Cards(blue);
            Cards c2 = new Cards(blue);
            Cards c3 = new Cards(green);
            Cards c4 = new Cards(red);

            playedPile.addCards(c1);
            playedPile.addCards(c2);
            playedPile.addCards(c3);
            playedPile.addCards(c4);

            Cards expected = c4;

            Assert.assertEquals(expected, playedPile.lastPlayedCard());
        }

}
