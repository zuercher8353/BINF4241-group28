public class Player {

    static int id = 0;
    public String name;
    public int playerid;

    public Player(String playerName) {
        this.name = playerName;
        this.playerid = id;
        id += 1;
    }
}
