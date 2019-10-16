import java.util.ArrayList;

public class Pawn implements Figur {
    boolean hasmoved;
    public Pawn(){
        this.hasmoved = false;
    }
    public boolean islegal(int[] array){ //nur 1 ausser am start, nur nach vorne laufen, muss deshalb wissen welche farbe er ist und auf welche Seite dieser Spieler spielt
        return true;
    }


    public ArrayList<Integer> path(int[] array) {
        ArrayList<Integer> path = new ArrayList<>();
        return path;
    }
}
