import java.util.ArrayList;

public class Pawn implements Figur {

    private String token = "P";
    private Boolean iswhite;
    Boolean hasmoved;
    private int figurid;
    static int id = 0;

    public Pawn(Boolean iswhite){
        this.hasmoved = false;
        this.iswhite = iswhite;
        this.figurid = id;
        id += 1;
    }
    public String getName() {
        return token;
    }

    public Boolean iswhite() {
        return iswhite;
    }

    @Override
    public String getToken() {
        return token;
    }

    public Boolean islegal(int[] array){ //nur 1 ausser am start, nur nach vorne laufen, muss deshalb wissen welche farbe er ist und auf welche Seite dieser Spieler spielt
        return true;
    }


    public ArrayList<Integer> path(int[] array) {
        ArrayList<Integer> path = new ArrayList<>();
        return path;
    }
}
