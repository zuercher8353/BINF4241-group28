public class Snake extends Square {
    private int start;
    private int end;

    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd(){
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Snake(int nr, String type, Boolean occupied, Boolean multiplePlayers, int snakestart, int snakeend){
        super(nr, type, occupied, multiplePlayers);
        this.start = snakestart;
        this.end = snakeend;

    }

}
