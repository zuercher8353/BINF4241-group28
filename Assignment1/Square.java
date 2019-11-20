public class Square {


    private String type;
    private boolean occupied;


    public Square(boolean occupied){
        this.occupied = occupied;
    }

    public void setOccupied(boolean occupied){
        this.occupied = occupied;
    }
    public boolean getOccupied(){
        return this.occupied;
    }

    public int getEnd(){
        return 0;
    }
}
