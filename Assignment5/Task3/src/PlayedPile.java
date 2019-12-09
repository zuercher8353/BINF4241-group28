package src;

import java.util.ArrayList;

public class PlayedPile implements CardDeck{
    private int nrOfCards;
    private ArrayList<Cards> playedCards;

    public ArrayList<Cards> removeCard(){
        return null;
    }

    public void addCards(Cards cards){

    }

    public boolean isEmpty(){
        return true;
    }

    public Cards lastPlayedCard(){
        return null;
    }

    public int getNrOfCards() {
        return nrOfCards;
    }
}
