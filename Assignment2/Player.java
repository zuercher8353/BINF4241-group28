import java.awt.*;

public class Player {
    private enum COLOR{
        B,
        W,
    };
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setColor(COLOR color) {
    }
    public void getColor() {

    }
}
