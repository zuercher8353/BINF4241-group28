import java.util.ArrayList;

public class King implements Figur {
    boolean hasmoved;

    public King(colour){
        this.hasmoved = false;

    }


    public boolean islegal(int[] array){
        if(Math.abs(array[0]-array[2]) > 1 || Math.abs(array[1]-array[3]) > 1) {
            return false;
        }
        if(Board.getFiguresArray(array[2],array[3]).getcolour == Board.getFiguresArray(array[0],array[1]).getcolour ){ //Figur an der position des Anfangspunktes
            return false;
        }
        return true;
    }


    public ArrayList<Integer> path(int[] array){
        ArrayList<Integer> path = new ArrayList<>();
        return path;
    }

}
