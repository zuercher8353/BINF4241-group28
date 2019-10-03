public class Square {

    private int nr;
    private String type;
    private Boolean occupied;
    private Boolean multiplePlayers;

    public Square(int nr, String type, Boolean occupied, Boolean multiplePlayers ){
        this.nr = nr;
        this.type = type;
        this.occupied = occupied;
        this.multiplePlayers = multiplePlayers;
    }

    public void setOccupied(Boolean occupied){
        this.occupied = occupied;
    }
    public boolean getOccupied(){
        return this.occupied;
    }

    public void setMultiplePlayersset(Boolean multiplePlayers){
        this.multiplePlayers = multiplePlayers;
    }

    public boolean getMultiplePlayers(){
        return this.multiplePlayers;
    }

    public int getNr(){
        return nr;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
