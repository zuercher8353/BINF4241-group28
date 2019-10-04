import java.util.Random;
public class Die {

    //static means that you don`t have to creat an object of the class before,
    public static int roll(){
        int min = 1;
        int max = 6;
        Random r = new Random();
        return r.nextInt((max-min)+1)+min;
    }
}
