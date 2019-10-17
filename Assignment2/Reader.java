import java.lang.reflect.Array;
import java.util.Scanner;

public class Reader {
    private enum FigureSTRs {P, T, N, Q, K}

    public void readMove() {
        int[] moveArray = new int[5];
        Boolean validInput = false;

        while (!validInput)

            try {
                //read Input
                Scanner moveScanner = new Scanner(System.in); // Create a Scanner object
                System.out.print("Move (Figure X, Position xx, Target xx: ");
                String moveInput = moveScanner.nextLine(); // Read Input

                //validate Input
                char figure = moveInput.charAt(0);
                int startX = moveInput.charAt(1);
                int startY = Character.getNumericValue(moveInput.charAt(2));
                int endX = Character.getNumericValue(moveInput.charAt(3));
                int endY = Character.getNumericValue(moveInput.charAt(4));

                //check if Indices are in Range
                if (startX >= 0 && startX < 8) {
                    moveArray[0] = startX;
                } else {
                    throw new ArithmeticException("Index out of Range");
                }

                if (startY >= 0 && startY < 8) {
                    moveArray[1] = startY;
                } else {
                    throw new ArithmeticException("Index out of Range");
                }
                if (endX >= 0 && endX < 8) {
                    moveArray[2] = endX;
                } else {
                    throw new ArithmeticException("Index out of Range");
                }
                if (endY >= 0 && endY < 8) {
                    moveArray[3] = endY;
                } else {
                    throw new ArithmeticException("Index out of Range");
                }

                validInput = true;

            } catch (Exception e) {
                System.out.print("Invalid Input!");
            }
    }

    private Boolean validateFigureChar(char inputFigureSTR) {
        for (FigureSTRs figureSTR : FigureSTRs.values()) {
            if (figureSTR.name().equals(inputFigureSTR)) {
                return true;
            }
        }
        return false;
    }
}
