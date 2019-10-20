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

    public Boolean iswhite() {
        return iswhite;
    }

    public void setHasMoved(boolean setHasMoved){
        hasmoved = setHasMoved;
    }


    @Override
    public String getToken() {
        return token;
    }

    public Boolean islegal(int[] array){ // Schräg laufen wenn figur geschlagen, noch nicht implementiert
        int x = array[0]-array[2];
        int y = array[1]-array[3];

        if((x == -1 && y == 0 && !iswhite)|| (x == -2 && y == 0 && !hasmoved && !iswhite) ){
            return true;
        }
        else if((x == 1 && y == 0 && iswhite)||(x == 2 && y == 0 && !hasmoved && iswhite)){
            return true;
        }
        else if(x == -1 && Math.abs(y)== 1 && !iswhite || x == 1 && Math.abs(y)== 1 && iswhite ){
            return true;
        }
        return false;
    }


    public ArrayList<Integer> path(int[] array) {
        ArrayList<Integer> path = new ArrayList<>();
        int x =  array[2]-array[0];
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
        return path;
    }
}
