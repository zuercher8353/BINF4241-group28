import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Arrays;

public class Reader {
    private enum FigureSTRs {P, T, N, Q, K}

    public int[] readMove() {
        int[] moveArray = new int[4];
        Boolean validInput = false;
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

        while (!validInput)

            try {
                //read Input
                Scanner moveScanner = new Scanner(System.in); // Create a Scanner object
                System.out.print("Move (Figure X, Position xx, Target xx: ");
                String moveInput = moveScanner.nextLine(); // Read Input

                //validate Input
                char figure = moveInput.charAt(0);
                char startX = moveInput.charAt(1);
                int startY = Character.getNumericValue(moveInput.charAt(2));
                char endX = moveInput.charAt(3);
                int endY = Character.getNumericValue(moveInput.charAt(4));

                //check empty input
                if (!moveInput.isEmpty()) {
                    //check if Indices are in Range
                    for (int i = 0; i < chars.length; i ++) {
                        if (startX == chars[i]) {
                            moveArray[0] = i;
                            //System.out.println(moveArray);
                        } else {
                            throw new ArithmeticException("Index out of Range");
                        }

                        if (endX == chars[i]) {
                            moveArray[2] = i;
                        } else {
                            throw new ArithmeticException("Index out of Range");
                        }
                    }
                    if (startY >= 0 && startY < 8) {
                        moveArray[1] = startY;
                    } else {
                        throw new ArithmeticException("Index out of Range");
                    }
                    if (endY >= 0 && endY < 8) {
                        moveArray[3] = endY;
                    } else {
                        throw new ArithmeticException("Index out of Range");
                    }
                    validInput = true;
                }

            } catch (Exception e) {
                System.out.println("Invalid Input!");
            }
        return moveArray;
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
