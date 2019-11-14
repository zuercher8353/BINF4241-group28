import java.util.ArrayList;

public interface Figur {
        public String getToken();
        public boolean islegal(int[] array);
        public ArrayList<Integer> path(int[] array);
        public boolean iswhite();
}
