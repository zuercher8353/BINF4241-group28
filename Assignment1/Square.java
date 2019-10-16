public class Square {


    private String type;
    private Boolean occupied;


    public Square(Boolean occupied){
        this.occupied = occupied;
    }

    public void setOccupied(Boolean occupied){
        this.occupied = occupied;
    }
    public boolean getOccupied(){
        return this.occupied;
    }

    public int getEnd(){
        return 0;
    }
}
