package src;

import java.util.ArrayList;

public class DrawPile implements CardDeck {
    private int nrOfCards;
    private ArrayList<Cards> deckCards;

    public Cards removeCard(){
        return null;
    }

    public void addCards(ArrayList<Cards> cards){

    }

    public boolean isEmpty(){
        return true;
    }

    public void shuffle(){

    }

    public int getNrOfCards(){
        return nrOfCards;
    }
}
