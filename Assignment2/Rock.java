import java.util.ArrayList;
public class Rock implements Figur {
    boolean hasmoved;
    public Rock(){
        this.hasmoved = false;
    }

    public boolean islegal(int[] array){
        if(array[0] != array[2] && array[1] != array[3] ) {
            return false;
        }
        if(Board.getFiguresArray(array[2],array[3]).getcolour == Board.getFiguresArray(array[0],array[1]).getcolour ){
            return false;
        }
        ArrayList <Integer> path = path(array);
        int x = path.size();
        for(int i=0; i<x; i +=2){
            if(Board.getFiguresArray(path.get(i),path.get(i+1)) != null){
                return false;
            }

        }
        return true;
    }


    public ArrayList<Integer> path(int[] array) {
        ArrayList<Integer> path = new ArrayList<>();
        if(array[0]!= array[2]){
            int x =  array[0]-array[2];
            if(x > 0){
                for(int i=1; i < x; i++ ){
                    path.add(array[0]+i);
                    path.add(array[1]);
                }}
            else{
                for(int i=-1; i > x; i-- ){
                    path.add(array[0]+i);
                    path.add(array[1]);
                }}
        }
        else{
            int y =  array[1]-array[3];
            if(y > 0){
                for(int i=1; i < y; i++ ){
                    path.add(array[0]);
                    path.add(array[1]+i);
                }}
            else{
                for(int i=-1; i > y; i-- ){
                    path.add(array[0]);
                    path.add(array[1]+i);
                }}
        }
        return path;
    }
}
