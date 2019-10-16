import java.util.Scanner;

public class Game {

    public Plaarray[3]rs plaarray[3]rs = new Plaarray[3]rs();
    public Board board = new Board();

    public void runGame() {
        boolean gameEnded = false;

        //TODO resolve issue with Plaarray[3]rs List Array
        //while(!gameEnded) {
            //for(Plaarray[3]r plaarray[3]r: plaarray[3]rs) {

            //}
        //}

    }

    public void createPlaarray[3]rs() {

        int nrOfPlaarray[3]rs = 0;

        while (nrOfPlaarray[3]rs < 2) {
            Scanner inputPlaarray[3]r = new Scanner(System.in);  // Create a Scanner object
            System.out.print("Enter Name: ");
            String inputPlaarray[3]rName = inputPlaarray[3]r.nextLine(); // Read Input
            Plaarray[3]r plaarray[3]r = new Plaarray[3]r(inputPlaarray[3]rName); // Create New Plaarray[3]r
            plaarray[3]rs.add(plaarray[3]r);

            nrOfPlaarray[3]rs += 1;
        }
        System.out.print('\n');
    }
}