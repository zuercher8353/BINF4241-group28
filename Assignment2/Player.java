import java.util.ArrayList;

public class Player {

   private static int id = 0;
    private String name;
    private int playerId;
    private boolean isWhite;
    private ArrayList<Object> eatenPieces = new ArrayList<>();

    public Player(String name) {
        this.playerId = id;
        this.name = name;
        this.id += 1;

        if(this.playerId == 0) {
            this.isWhite = true;
        } else {
            this.isWhite = false;
        }
    }
    public String getName() {
        return this.name;
    }

    public boolean isPlayerWhite() {
        return isWhite;
    }

    public String getColourSTR() {
        if (this.isPlayerWhite()) {
            return "W";
        }
        else {
            return "B";
        }
    }

    public void addEatenPiece(Object object) {
        eatenPieces.add(object);
    }
    public void showEatenPieces() {
        for(Object eatenPiece : eatenPieces) {
            System.out.println(eatenPiece.getClass().getName() + ", ");
        }
    }

    //TODO possibly integrate  //java.util.Iterator<E> as suggested in lecture
}
