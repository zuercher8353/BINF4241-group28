public class Board {
    private int boardsize;
    private int[] snakestart= new int[100];
    private int[] snakeend = new int[100];
    private int[] ladderstart = new int[100];
    private int[] ladderend = new int[100];
    Square[] squares = new Square[boardsize];

    public Board(int boardsize){
        this.boardsize = boardsize;
    }
    public int getBoardsize() {
        return boardsize;
    }
    public int[] getSnakestart(){
        return snakestart;
    }

    public int[] getLadderstart(){
        return ladderstart;
    }

    public int[] getLadderend() {
        return ladderend;
    }


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


    public Square[] initsquare() {
        int laddercount = 0;
        int snakecount = 0;
        int c =0;
        for(int i=1; i < (boardsize- 4);i+=5){
            ladderstart[c] = i;
            ladderend[c] = i+3;
        }
        for(int i=5; i < (boardsize- 2);i+=5){
            snakestart[c] = i;
            snakeend[c] = i-3;
        }


        for (int count = 0; count < boardsize; count++) {
            if (contains(count, snakestart)) {
                squares[count] = new Snake(false, snakestart[snakecount], snakeend[snakecount]);
                snakecount++;
            } else if (contains(count, ladderstart)) {
                squares[count] = new Ladder(false, ladderstart[laddercount], ladderend[laddercount]);
                laddercount++;
            } else {
                if (count == 0) {
                    squares[count] = new Square(false);
                } else {
                    squares[count] = new Square(false);
                }
            }
        }
        return squares;
    }
}



