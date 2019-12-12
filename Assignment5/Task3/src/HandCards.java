package src;

import java.util.ArrayList;

public class HandCards implements CardDeck {
    private int nrOfCards;
    private ArrayList<Cards> handCards;

    public Cards removeCard(Cards cards){
        return null;
    }

    public void addCards(Cards cards){

    }

    public boolean isEmpty(){
        return true;
    }

    public ArrayList<Cards> getHandCards(){
        return handCards;
    }

    public int getNrOfCards() {
        return nrOfCards;
    }
}
