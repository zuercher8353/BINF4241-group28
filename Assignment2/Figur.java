import java.util.ArrayList;

public interface Figur {
    public String getToken();
    public Boolean islegal(int[] array);
    public ArrayList<Integer> path(int[] array);
    public Boolean iswhite();

}
