import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    private char[] FigureSTRs = {'P', 'T', 'N', 'Q', 'K'};
    private char[] fieldSTRs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    private boolean rochade = false;

    public ArrayList<Object> readMove() {
        ArrayList<Object> moveArray = new ArrayList<>();
        Boolean validInput = false;

        while (!validInput)

            try {
                //read Input
                Scanner moveScanner = new Scanner(System.in); // Create a Scanner object
                System.out.println("What kind of move? (normal, rochade)");
                String kindInput = moveScanner.nextLine();
                System.out.print("Move (Figure X, Position xx, Target xx: ");
                String moveInput = moveScanner.nextLine(); // Read Input

                //check if rochade
                if(kindInput.equals("rochade")){
                    rochade = true;
                }
                //check empty input
                    if (!moveInput.isEmpty() && !kindInput.isEmpty()) {

                        //convert input
                        char figure = Character.toUpperCase(moveInput.charAt(0));
                        char startX = Character.toUpperCase(moveInput.charAt(1));
                        int startY = Character.getNumericValue(moveInput.charAt(2));
                        char endX = Character.toUpperCase(moveInput.charAt(3));
                        int endY = Character.getNumericValue(moveInput.charAt(4));

                        //TODO Mulitple Exceptions

                        //validate Input
                        if (!validateFigureChar(figure)) {
                            System.out.print("None Existing Figure. ");
                            throw new NoSuchObjectException("None Existing Figure");
                        } else {
                            moveArray.add(0, figure);
                        }
                        if ((!validateFieldChar(startX)) || (!validateFieldChar(endX))) {
                            System.out.print("None Existing Field. ");
                            throw new NoSuchFieldException();
                        }

                        //check if Indices are in Range


                        if (startY >= 0 && startY < 8) {
                            moveArray.add(1, startY);
                        } else {
                            System.out.print("Index out of Range. ");
                            throw new ArithmeticException();
                        }

                        //write startX in array index 2
                        for (int i = 0; i < fieldSTRs.length; i++) {
                            if (startX == fieldSTRs[i]) {
                                moveArray.add(2, i);
                            }
                        }


                        if (endY >= 0 && endY < 8) {
                            moveArray.add(3, endY);
                        } else {
                            System.out.print("Index out of Range. ");
                            throw new ArithmeticException();
                        }


                        for (int i = 0; i < fieldSTRs.length; i++) {
                            if (endX == fieldSTRs[i]) {
                                moveArray.add(4, i);
                            }
                        }

                        validInput = true;

                    } else {
                        System.out.println("empty Input!");
                    }

                } catch(Exception e){
                    System.out.println("Invalid Input!");
                }
        return moveArray;
    }

    private Boolean validateFigureChar(char inputFigureSTR) {
        for (char figureSTR : FigureSTRs) {
            if (figureSTR == inputFigureSTR) {
                return true;
            }
        }
        return false;
    }

    private Boolean validateFieldChar(char inputfieldSTR) {
        for (char fieldSTR : fieldSTRs) {
            if (fieldSTR == inputfieldSTR) {
                return true;
            }
        }
        return false;
    }
}
