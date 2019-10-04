public class Ladder extends Square {
    private int start;
    private int end;

    public Ladder(int nr, String type, Boolean occupied, Boolean multiplePlayers, int ladderstart, int ladderend){
        super(nr, type, occupied, multiplePlayers);
        this.start = ladderstart;
        this.end = ladderend;
    }
    @Override
    public int getEnd() {
        return this.end;
    }
}
