public class Scoreboard implements Observer {
    private int scoreWhite = 0;
    private int scoreBlack = 0;

    public void update(boolean isWhite, int points){
        if(isWhite){
            scoreWhite += points;
        }
        else {
            scoreBlack += points;
        }
    }

    public int getScoreBlack() {
        return scoreBlack;
    }

    public int getScoreWhite() {
        return scoreWhite;
    }
}
