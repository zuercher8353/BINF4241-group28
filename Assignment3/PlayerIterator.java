import java.util.ArrayList;
import java.util.List;

public class PlayerIterator implements Iterator {
    private List<Player> players = new ArrayList<>();
    private int position = 0;

    public PlayerIterator(List<Player> players) {
        this.players = players;
    }

    @Override
    public boolean hasNext() {
        if (position >= players.size() || players.get(position) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Player next() {
        Player player = players.get(position);
        position += 1;
        return player;
    }

    //additional method to get other player without iterating
    public Player otherPlayer() {
        if (position < players.size()-1) {
            Player player = players.get(position+1);
            return player;
        } else {
            // if no next player, set position to first and return player
            Player player = players.get(0);
            return player;
        }
    }
}


