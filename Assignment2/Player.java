import java.awt.*;

public class Player {

   private static int id = 0;
    private String name;
    private int playerId;
    private boolean isWhite;

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

    public Boolean isPlayerWhite() {
        return isWhite;
    }

    //TODO add Colors
    //TODO possibly integrate  //java.util.Iterator<E> as suggested in lecture
}
