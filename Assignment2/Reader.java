import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    private char[] FigureSTRs = {'P', 'T', 'N', 'Q', 'K', 'B'};
    private char[] fieldSTRs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

    public ArrayList<Object> readMove() {
        ArrayList<Object> moveArray = new ArrayList<>();
        Boolean validInput = false;

        while (!validInput)

            try {
                //read Input
                Scanner moveScanner = new Scanner(System.in); // Create a Scanner object
                System.out.print("Move? (Figure X, Position xx, Target xx): ");
                String moveInput = moveScanner.nextLine(); // Read Input

                //check empty input
                if (!moveInput.isEmpty()) {

                    if (moveInput.equals("O-O")) {
                        moveArray.add("Rochade_Small");
                        validInput = true;
                    }
                    else if (moveInput.equals("O-O-O")) {
                        moveArray.add("Rochade_Large");
                        validInput = true;
                    }
                    else {
                        //convert input
                        char figure = Character.toUpperCase(moveInput.charAt(0));
                        char startX = Character.toUpperCase(moveInput.charAt(1));
                        int startY = Character.getNumericValue(moveInput.charAt(2));
                        char endX = Character.toUpperCase(moveInput.charAt(3));
                        int endY = Character.getNumericValue(moveInput.charAt(4));

                        if (moveInput.length()==6) {
                            char figurePromoted = Character.toUpperCase(moveInput.charAt(5));
                        }

                        //TODO Mulitple Exceptions

                        //validate Input
                        if (!validateFigureChar(figure)) {
                            throw new Exception("None Existing Figure");
                        } else {
                            moveArray.add(0, figure);
                        }
                        if ((!validateFieldChar(startX)) || (!validateFieldChar(endX))) {
                            throw new Exception("None Existing Field");
                        }

                        //check if Indices are in Range


                        if (startY > 0 && startY <= 8) {
                            //write numeric start value in moveArray, convert to mirrored numeric Y axis
                            //by subtracting 8
                            moveArray.add(1, 8-startY);
                        } else {
                            throw new ArithmeticException("Index out of Range");
                        }

                        for (int i = 0; i < fieldSTRs.length; i++) {
                            if (startX == fieldSTRs[i]) {
                                moveArray.add(2, i);
                            }
                        }

                        if (endY > 0 && endY <= 8) {
                            moveArray.add(3, 8-endY);
                        } else {
                            throw new ArithmeticException("Index out of Range");
                        }

                        for (int i = 0; i < fieldSTRs.length; i++) {
                            if (endX == fieldSTRs[i]) {
                                moveArray.add(4, i);
                            }
                        }

                        validInput = true;
                    }

                } else {
                    System.out.println("empty Input!");
                }


            } catch (Exception e) {
                System.out.println("Invalid Input!");
            }

        //move Array output style: { Figure, Ystart, Xstart, Yend, Xend }
        //axis: Y (top-bottom)- 0-7 // X (left-right)- 0-7
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
