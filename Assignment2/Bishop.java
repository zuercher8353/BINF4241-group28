import java.util.ArrayList;
public class Bishop implements Figur {

    private String token = "B";
    private boolean iswhite;
    private int figurid;
    static int id = 0;


    public Bishop(boolean iswhite){
        this.iswhite = iswhite;
        this.figurid = id;
        id += 1;

    }

    public boolean iswhite() {
        return iswhite;
    }

    public String getToken() {
        return token;
    }

    public boolean islegal(int []array){
        boolean islegal = false;
        if(array[0] != array[2] && array[1] != array[3] ) {
            if(Math.abs(array[0] - array[2])== Math.abs(array[1] - array[3])){
                islegal = true;
            }
        }
        return islegal;
    }

    public ArrayList<Integer> path(int[] array) {
        ArrayList<Integer> path = new ArrayList<>();
        int x =  array[2]-array[0];
        int y = array[3] - array[1];
        if(x > 0 && y > 0){
            for(int i=1; i < x; i++ ){
                path.add(array[0]+i);
                path.add(array[1]+i);
            }}
        else if(x<0 && y < 0){
            for(int i=-1; i > x; i-- ){
                path.add(array[0]+i);
                path.add(array[1]+i);
            }}
        else if(x>0 && y<0){
            for(int i=1; i < x; i++ ){
                path.add(array[0]+i);
                path.add(array[1]-i);
            }}
        else{
            for(int i=-1; i > x; i-- ){
                path.add(array[0]+i);
                path.add(array[1]-i);
            }
        }
        return path;
    }
}

