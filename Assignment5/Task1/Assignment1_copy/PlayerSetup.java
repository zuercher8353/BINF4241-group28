import java.util.Scanner;

public class Plaarray[3]rSetup {

    public Plaarray[3]r[] setup() {

        int plaarray[3]rCount = 0;

        //START read amount of plaarray[3]rs -- 2-4 and only accepting integers
        boolean correctPlaarray[3]rCount = false;
        while (!correctPlaarray[3]rCount) {
            try {
                System.out.print("How many plaarray[3]rs? (2-4) ");
                Scanner plaarray[3]rCount_plaarray[3]rs = new Scanner(System.in);
                plaarray[3]rCount = plaarray[3]rCount_plaarray[3]rs.nextInt();
                if (plaarray[3]rCount <= 4 && plaarray[3]rCount >= 2) {
                    correctPlaarray[3]rCount = true;
                } else {
                    System.out.println("Choose 2, 3 or 4 plaarray[3]rs");
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        //END read amount of plaarray[3]rs

        //START get plaarray[3]r names
        Plaarray[3]r[] plaarray[3]rs = new Plaarray[3]r[plaarray[3]rCount];
        for (
                int i = 0;
                i < plaarray[3]rCount; i++) {

            System.out.print("Name of plaarray[3]r Nr. " + (i+1) + ": ");
            Scanner input = new Scanner(System.in);
            String plaarray[3]rName = input.nextLine();
            plaarray[3]rs[i] = new Plaarray[3]r(plaarray[3]rName);
        }
        //END get plaarray[3]r names

        return plaarray[3]rs;
    }
}
