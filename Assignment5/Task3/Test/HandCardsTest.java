package Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.*;

import java.util.ArrayList;

public class HandCardsTest {


    private HandCards handcards = new HandCards();

    @Before
    public void setup(){
        handcards = new HandCards();
    }


    /**
     * This test checks if the length of the handcards equals nrOfCards
     */
    @Test
    public void nrOfCards(){
        Cards c1 = new NumberCard("blue", 1);
        Cards c2 = new NumberCard("blue", 2);
        Cards c3 = new NumberCard("green",7);
        Cards c4 = new NumberCard("red", 5);

        handcards.addCards(c1);
        handcards.addCards(c2);
        handcards.addCards(c3);
        handcards.addCards(c4);

        Assert.assertEquals(4, handcards.getNrOfCards());
    }


    /**
     * this test checks the method isEmpty and addCards()
     */
    @Test
    public void isEmpty(){
        Assert.assertTrue(handcards.isEmpty());

        Cards c1 = new NumberCard("blue", 1);
        Cards c2 = new NumberCard("blue", 2);

        handcards.addCards(c1);
        handcards.addCards(c2);

        Assert.assertEquals(2, handcards.getNrOfCards());
        Assert.assertFalse(handcards.isEmpty());


    }

    /**
     * this test checks if removeCard() works
     */
    @Test
    public void removeCardWorks(){
        Cards c1 = new NumberCard("blue", 1);
        Cards c2 = new NumberCard("blue", 2);
        Cards c3 = new NumberCard("green",7);
        Cards c4 = new NumberCard("red", 5);

        handcards.addCards(c1);
        handcards.addCards(c2);
        handcards.addCards(c3);
        handcards.addCards(c4);

        Cards removed = handcards.removeCard(c1);
        Assert.assertEquals(3, handcards.getNrOfCards());

        Assert.assertEquals(c1, removed);
    }


    /**
     * This test checks if the handcards is empty after removing all cards
     */
    @Test
    public void isEmptyRemove(){
        Cards c1 = new NumberCard("blue", 1);
        Cards c2 = new NumberCard("blue", 2);
        Cards c3 = new NumberCard("green",7);
        Cards c4 = new NumberCard("red", 5);

        handcards.addCards(c1);
        handcards.addCards(c2);
        handcards.addCards(c3);
        handcards.addCards(c4);

        Cards r1 = handcards.removeCard(c1);
        Cards r2 = handcards.removeCard(c2);
        Cards r3 = handcards.removeCard(c3);
        Cards r4 = handcards.removeCard(c4);


        Assert.assertEquals(0, handcards.getNrOfCards());
        Assert.assertTrue(handcards.isEmpty());
    }


    /**
     * this test checks if getHandCards works
     */
    @Test
    public void getCards(){
        ArrayList<Cards> handCards = new ArrayList<>() {{
            add(new NumberCard("blue", 1));
            add(new NumberCard("blue", 2));
            add(new NumberCard("green",7));
            add(new NumberCard("red", 5));
        }};

        Cards c1 = new NumberCard("blue", 1);
        Cards c2 = new NumberCard("blue", 2);
        Cards c3 = new NumberCard("green",7);
        Cards c4 = new NumberCard("red", 5);

        handcards.addCards(c1);
        handcards.addCards(c2);
        handcards.addCards(c3);
        handcards.addCards(c4);

        Assert.assertEquals(handCards, handcards.getHandCards());
    }
}
