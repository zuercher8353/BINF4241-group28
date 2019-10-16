import java.util.ArrayList;
public class Bishop implements Figur {
    public boolean islegal(int []array){
        boolean islegal = false;
        if(array[0] != array[1] && array[2] != array[3] ) {
            if(Math.abs(array[0] - array[2])== Math.abs(array[1] - array[3])){
                islegal = true;
            }
        }
        if(islegal){
            while (array[0] != array[2] || array[1] != array[3]){
                if(board.isempty(array[0],array[1])){
                    return false;
                }
                if(array[0] != array[2]){
                    array[0]++;
                }
                if(array[1] != array[3]) {
                    array[1]++;
                }
                if(array[0] == array[2] && array[1] == array[3]){
                    if(board.isown(array[0],array[1])){
                        return false;
                    } }
            } }
        return islegal;
    }

}
}
