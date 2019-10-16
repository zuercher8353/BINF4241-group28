import java.util.ArrayList;
public class Knight implements Figur {

    public Knight() {

    }

    public boolean islegal(int[] array) {
        boolean islegal = false;
        if (Math.abs(array[0] - array[2]) == 3 && Math.abs(array[1] - array[3]) == 1 || Math.abs(array[0] - array[2]) == 1 && Math.abs(array[1] - array[3]) == 3) {
            islegal = true;
        }
        if (islegal) {
            if (Board.getFiguresArray(array[2], array[3]).getcolour == Board.getFiguresArray(array[0], array[1]).getcolour) { //Figur an der position des Anfangspunktes
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