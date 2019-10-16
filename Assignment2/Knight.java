import java.util.ArrayList;
public class Knight implements Figur {

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

    public Boolean islegal(int[] array) {
        Boolean islegal = false;
        if (Math.abs(array[0] - array[2]) == 3 && Math.abs(array[1] - array[3]) == 1 || Math.abs(array[0] - array[2]) == 1 && Math.abs(array[1] - array[3]) == 3) {
            islegal = true;
        }
        if (islegal) {
            if (Board.getFiguresArray(array[2], array[3]).iswhite() == Board.getFiguresArray(array[0], array[1]).iswhite()) { //Figur an der position des Anfangspunktes
                return false;
            }
        }
        return islegal;
    }


    public ArrayList<Integer> path(int[] array) {
        ArrayList<Integer> path = new ArrayList<>();
        return path;
    }
}