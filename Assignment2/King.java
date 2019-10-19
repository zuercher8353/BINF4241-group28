import java.util.ArrayList;

public class King implements Figur {

    private String token = "K";
    private Boolean hasmoved;
    private Boolean iswhite;
    private int figurid;
    static int id = 0;

    public King(Boolean iswhite){
        this.hasmoved = false;
        this.iswhite = iswhite;
        this.figurid = id;
        id += 1;


    }

    public Boolean iswhite() {
        return iswhite;
    }

    public String getToken() {
        return token;
    }

    public Boolean islegal(int[] array){
        if(Math.abs(array[0]-array[2]) > 1 || Math.abs(array[1]-array[3]) > 1) {
            return false;
        }
        return true;
    }


    public ArrayList<Integer> path(int[] array){
        ArrayList<Integer> path = new ArrayList<>();
        return path;
    }



}
