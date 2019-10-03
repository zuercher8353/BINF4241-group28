public class Snake extends Square {
    private int start;
    private int end;

    public Snake(int nr, String type, Boolean occupied, Boolean multiplePlayers, int snakestart, int snakeend){
        super(nr, type, occupied, multiplePlayers);
        this.start = snakestart;
        this.end = snakeend;

    }

}
