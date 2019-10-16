import java.util.ArrayList;
public class Knight implements Figur {

    public boolean islegal(int[] array){
        if(Math.abs(array[0] - array[2])== 3 && Math.abs(array[1] - array[3])==1 || Math.abs(array[0] - array[2])== 1 && Math.abs(array[1] - array[3])==3 ){
        islegal = true;
    }
        if(islegal){
        if(board.isown(array[0],array[1])){
            return false;
        }}
        return islegal;
}
}
