public class Player {

    static int id = 0;
    public String name;

    public Player(String playerName) {
        this.name = playerName;
        id += 1;
    }
}
