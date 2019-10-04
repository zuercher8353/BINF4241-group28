public class Board {
    private int boardsize = 12;
    private int[] snakestart = {10};
    private int[] snakeend = {4};
    private int[] ladderstart = {1, 6};
    private int[] ladderend = {5, 8};
    Square[] squares = new Square[boardsize];

    private static boolean contains(int key, int[] array) {
        boolean contain = false;
        for (int i = 0; i < array.length; i++) {
            if (key == array[i]) {
                contain = true;
                break;
            }
        }
        return contain;
    }

    public int getBoardsize() {
        return boardsize;
    }

    public Square[] initsquare() {
        int laddercount = 0;
        int snakecount = 0;

        for (int count = 0; count < boardsize; count++) {
            if (contains(count, snakestart)) {
                squares[count] = new Snake(count, "Snake", false, false, snakestart[snakecount], snakeend[snakecount]);
                snakecount++;
            } else if (contains(count, ladderstart)) {
                squares[count] = new Ladder(count, "Ladder", false, false, ladderstart[laddercount], ladderend[laddercount]);
                laddercount++;
            } else {
                if (count == 0) {
                    squares[count] = new Square(count, "normal", false, true);
                } else {
                    squares[count] = new Square(count, "normal", false, false);
                }
            }
        }
        return squares;
    }
}



