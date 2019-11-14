import java.util.ArrayList;

public class King implements Figur {

    private String token = "K";
    private boolean hasmoved;
    private boolean iswhite;
    private int figurid;
    static int id = 0;

    public King(boolean iswhite){
        this.hasmoved = false;
        this.iswhite = iswhite;
        this.figurid = id;
        id += 1;

    }
    public void setHasMoved(boolean setHasMoved){
        hasmoved = setHasMoved;
    }

    public boolean iswhite() {
        return iswhite;
    }

    public String getToken() {
        return token;
    }

    public boolean islegal(int[] array){
        if(Math.abs(array[0]-array[2]) > 1 || Math.abs(array[1]-array[3]) > 1) {
            return false;
        }
        return true;
    }

    public boolean getHasmoved() {
        return hasmoved;
    }

    public ArrayList<Integer> path(int[] array){
        ArrayList<Integer> path = new ArrayList<>();
        return path;
    }



}
