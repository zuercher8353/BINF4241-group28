import java.util.ArrayList;
public class Bishop implements Figur {

    private Boolean iswhite;
    private int figurid;
    static int id = 0;

    public Bishop(Boolean iswhite){
        this.iswhite = iswhite;
        this.figurid = id;
        id += 1;

    }

    public Boolean iswhite() {
        return iswhite;
    }

    public Boolean islegal(int []array){
        Boolean islegal = false;
        if(array[0] != array[1] && array[2] != array[3] ) {
            if(Math.abs(array[0] - array[2])== Math.abs(array[1] - array[3])){
                islegal = true;
            }
        }
        if(islegal){
            if(Board.getFiguresArray(array[2],array[3]).iswhite() == Board.getFiguresArray(array[0],array[1]).iswhite() ){
                return false;
            }
            ArrayList <Integer> path = path(array);
            int x = path.size();
            for(int i=0; i<x; i +=2){
                if(Board.getFiguresArray(path.get(i),path.get(i+1)) != null){
                    return false;
                }
            }}
        return islegal;
    }

    public ArrayList<Integer> path(int[] array) {
        ArrayList<Integer> path = new ArrayList<>();
        int x =  array[0]-array[2];
        if(x > 0){
            for(int i=1; i < x; i++ ){
                path.add(array[0]+i);
                path.add(array[1]+i);
            }}
        else{
            for(int i=-1; i > x; i-- ){
                path.add(array[0]+i);
                path.add(array[1]+i);
            }}
        return path;
    }
}

