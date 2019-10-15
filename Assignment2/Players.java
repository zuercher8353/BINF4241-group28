import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Players {

    //excaping references
    private List<Player> playerList = new ArrayList<>();

    public void add(Player player) {
        playerList.add(player);
    }
}
