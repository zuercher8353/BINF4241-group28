import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class HandCardsTest {


    HandCards handcards = new HandCards();

    @Before
    public void setup(){
        handcards = new HandCards();
    }


    /**
     * This test checks if the length of the handcards equals nrOfCards
     */
    @Test
    public void nrOfCards(){
        Cards c1 = new Cards(blue);
        Cards c2 = new Cards(blue);
        Cards c3 = new Cards(green);
        Cards c4 = new Cards(red);

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

        Cards c1 = new Cards(blue);
        Cards c2 = new Cards(blue);

        handcards.addCards(c1);
        handcards.addCards(c2);

        Assert.assertEquals(2, handcards.getNrOfCards());
        Assert.assertFalse(handcards.isEmpty())


    }

    /**
     * this test checks if removeCard() works
     */
    @Test
    public void removeCardWorks(){
        Cards c1 = new Cards(blue);
        Cards c2 = new Cards(blue);
        Cards c3 = new Cards(green);
        Cards c4 = new Cards(red);

        handcards.addCards(c1);
        handcards.addCards(c2);
        handcards.addCards(c3);
        handcards.addCards(c4);

        Cards removed = handcards.removeCard();
        Cards card = new Cards(blue);
        Assert.assertEquals(3, handcards.getNrOfCards());

        Assert.assertEquals(card, removed);
    }


    /**
     * This test checks if the handcards is empty after removing all cards
     */
    @Test
    public void isEmptyRemove(){
        Cards c1 = new Cards(blue);
        Cards c2 = new Cards(blue);
        Cards c3 = new Cards(green);
        Cards c4 = new Cards(red);

        handcards.addCards(c1);
        handcards.addCards(c2);
        handcards.addCards(c3);
        handcards.addCards(c4);

        Cards r1 = handcards.removeCard();
        Cards r2 = handcards.removeCard();
        Cards r3 = handcards.removeCard();
        Cards r4 = handcards.removeCard();


        Assert.assertEquals(0, handcards.getNrOfCards());
        Assert.assertTrue(handcards.isEmpty());
    }


    /**
     * this test checks if correct handcards are returned
     */
    @Test
    public void getCards(){
        ArrayList<Cards> handCards = new ArrayList<>() {{
            add(new Cards(blue));
            add(new Cards(blue);
            add(new Cards(green));
            add(new Cards(red));
        }};

        Cards c1 = new Cards(blue);
        Cards c2 = new Cards(blue);
        Cards c3 = new Cards(green);
        Cards c4 = new Cards(red);

        handcards.addCards(c1);
        handcards.addCards(c2);
        handcards.addCards(c3);
        handcards.addCards(c4);

        Assert.assertEquals(handCards, handcards.getHandCards());
    }
}
