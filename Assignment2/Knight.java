import java.util.ArrayList;
public class Knight implements Figur {

    private String token = "N";
    private Boolean iswhite;
    private int figurid;
    static int id = 0;

    public Knight(Boolean iswhite) {
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

    public Boolean islegal(int[] array) {
        Boolean islegal = false;
        if (Math.abs(array[0] - array[2]) == 2 && Math.abs(array[1] - array[3]) == 1 || Math.abs(array[0] - array[2]) == 1 && Math.abs(array[1] - array[3]) == 2) {
            islegal = true;
        }
        return islegal;
    }


    public ArrayList<Integer> path(int[] array) {
        ArrayList<Integer> path = new ArrayList<>();
        return path;
    }
}