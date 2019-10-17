import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    private char[] FigureSTRs = {'P', 'T', 'N', 'Q', 'K'};
    private char[] fieldSTRs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

    public ArrayList<Object> readMove() {
        ArrayList<Object> moveArray = new ArrayList <Object>();
        Boolean validInput = false;

        while (!validInput)

            try {
                //read Input
                Scanner moveScanner = new Scanner(System.in); // Create a Scanner object
                System.out.print("Move (Figure X, Position xx, Target xx: ");
                String moveInput = moveScanner.nextLine(); // Read Input



                //check empty input
                if (!moveInput.isEmpty()) {

                    //convert input
                    char figure = Character.toUpperCase(moveInput.charAt(0));
                    char startX = Character.toUpperCase(moveInput.charAt(1));
                    int startY = Character.getNumericValue(moveInput.charAt(2));
                    char endX = Character.toUpperCase(moveInput.charAt(3));
                    int endY = Character.getNumericValue(moveInput.charAt(4));

                    //TODO Mulitple Exceptions

                    //validate Input
                    if(!validateFigureChar(figure)) {
                        throw new Exception("None Existing Figure");
                    } else {
                        moveArray.set(0, figure);
                    }
                    if((!validateFieldChar(startX)) || (!validateFieldChar(endX))) {
                        throw new Exception("None Existing Figure");
                    }

                    //check if Indices are in Range
                    for (int i = 0; i < fieldSTRs.length; i ++) {
                        if (startX == fieldSTRs[i]) {
                            moveArray.set(1, i);
                        }
                        if (endX == fieldSTRs[i]) {
                            moveArray.set(2, i);
                        }
                    }
                    if (startY >= 0 && startY < 8) {
                        moveArray.set(3, startY);
                    } else {
                        throw new ArithmeticException("Index out of Range");
                }
                    if (endY >= 0 && endY < 8) {
                        moveArray.set(4, endY);
                    } else {
                        throw new ArithmeticException("Index out of Range");
                    }
                    validInput = true;
                } else {
                    System.out.println("empty Input!");
                }


            } catch (Exception e) {
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
