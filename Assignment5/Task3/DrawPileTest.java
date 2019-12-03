import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * This testclass tests the class DrawPile
 */
public class DrawPileTest {
    DrawPile drawPile1 = new DrawPile();

    @Before
    public void setup(){
        drawPile1 = new DrawPile();
    }


    /**
     * This test checks if the length of the pile equals nrOfCards
     */
    @Test
    public void nrOfCards(){
        ArrayList<Cards> drawPile = new ArrayList<>() {{
            add(new Cards(blue));
            add(new Cards(blue);
            add(new Cards(green));
            add(new Cards(red));
        }};

        Assert.assertEquals(drawPile.size(), drawPile.getNrOfCards());
    }
    /**
     * this test checks if the method isEmpty returns true if drawpile is empty
     */
    @Test
    public void isEmpty(){
        ArrayList<Cards> drawPile = new ArrayList<>() {{
        }};
        boolean empty = drawPile.isEmpty();
        Assert.assertTrue(empty);
    }

    /**
     * this test checks if removeCard() succesfully removes the top card of the pile
     */
    @Test
    public void removeCardWorks(){
        ArrayList<Cards> drawPile = new ArrayList<>() {{
            add(new Cards(blue));
            add(new Cards(blue);
            add(new Cards(green));
            add(new Cards(red));
        }};
        drawPile.removeCard();
        ArrayList<Cards> drawPileAfter = new ArrayList<>() {{
            add(new Cards(blue);
            add(new Cards(green));
            add(new Cards(red));
        }};
        Cards card = drawPile.removeCard();
        Assert.assertEquals(3, drawPile.getNrOfCards());

        Assert.assertEquals(drawPileAfter, drawPile);
    }


    /**
     * This test checks if removeCard() returns the top card
     */
    @Test
    public void removeTopCard(){
        ArrayList<Cards> drawPile = new ArrayList<>() {{
            add(new Cards(blue));
            add(new Cards(blue);
            add(new Cards(green));
            add(new Cards(red));
        }};
        Cards expected = new Cards(blue);
        Cards card = drawPile.removeCard();

        Assert.assertEquals(expected, card);
    }


    /**
     * This test checks if new cards are added to old drawPile
     */
    @Test
    public void addCards(){
        ArrayList<Cards> drawPile = new ArrayList<>() {{
            add(new Cards(blue));
            add(new Cards(blue);
            add(new Cards(green));
            add(new Cards(red));
        }};

        ArrayList<Cards> drawPileToAdd = new ArrayList<>() {{
            add(new Cards(yellow));
            add(new Cards(blue);
        }};

        drawPile.addCards(drawPileToAdd);

        ArrayList<Cards> AddedDrawPile = new ArrayList<>() {{
            add(new Cards(blue));
            add(new Cards(blue);
            add(new Cards(green));
            add(new Cards(red));
        }};

        Assert.assertEquals(AddedDrawPile, drawPile);
    }

    /**
     * This test checks if the pile has same length after shuffling
     */
    @Test
    public void shuffle(){
        ArrayList<Cards> drawPile = new ArrayList<>() {{
            add(new Cards(blue));
            add(new Cards(blue);
            add(new Cards(green));
            add(new Cards(red));
        }};

        drawPile.shuffle();

        Assert.assertEquals(4, drawPile.getNrOfCards());

    }


    /**
     * This test checks if the pile is empty after removing all cards
     */
    @Test
    public void isEmptyRemove(){
        ArrayList<Cards> drawPile = new ArrayList<>() {{
            add(new Cards(blue));
            add(new Cards(blue);
            add(new Cards(green));
            add(new Cards(red));
        }};

        drawPile.removeCard();
        drawPile.removeCard();
        drawPile.removeCard();
        drawPile.removeCard();

        ArrayList<Cards> drawPileAfter = new ArrayList<>() {{
        }};

        Assert.assertEquals(0, drawPile.getNrOfCards);
        Assert.assertEquals(true, drawPile.isEmpty());
    }
}
