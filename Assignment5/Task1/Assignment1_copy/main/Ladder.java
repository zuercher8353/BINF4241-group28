package main;

public class Ladder extends Square {
    private int start;
    private int end;

    public Ladder(boolean occupied, int ladderstart, int ladderend){
        super(occupied);
        this.start = ladderstart;
        this.end = ladderend;
    }
    @Override
    public int getEnd() {
        return this.end;
    }
}
