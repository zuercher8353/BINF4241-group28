package main;

public class Snake extends Square {
    private int start;
    private int end;


    public Snake(boolean occupied,int snakestart, int snakeend){
        super(occupied);
        this.start = snakestart;
        this.end = snakeend;
    }

    @Override
    public int getEnd() {
        return this.end;
    }
}
