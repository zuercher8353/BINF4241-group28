package main;

public class Board {
    private int boardsize;
    private int[] snakestart= new int[100];
    private int[] snakeend = new int[100];
    private int[] ladderstart = new int[100];
    private int[] ladderend = new int[100];

    public Board(int boardsize){
        this.boardsize = boardsize;
    }
    public int getBoardsize() {
        return boardsize;
    }

    private boolean contains(int key, int[] array) {
        boolean contain = false;
        for (int i = 0; i < array.length; i++) {
            if (key == array[i]) {
                contain = true;
                break;
            }
        }
        return contain;
    }

    public Square[] initSquares() {
        Square[] squares = new Square[boardsize];
        int laddercount = 0;
        int snakecount = 0;
        int c =0;
        int d =0;
        for(int i=1; i < (boardsize- 4);i+=5){
            ladderstart[c] = i;
            ladderend[c] = i+3;
            c++;
        }
        for(int i=5; i < (boardsize- 2);i+=5){
            snakestart[d] = i;
            snakeend[d] = i-3;
            d++;
        }

        for (int count = 0; count < boardsize; count++) {
            if (count == 0) {
                squares[count] = new Square(false);}
            else if (contains(count, snakestart)) {
                squares[count] = new Snake(false, snakestart[snakecount], snakeend[snakecount]);
                snakecount++;
            } else if (contains(count, ladderstart)) {
                squares[count] = new Ladder(false, ladderstart[laddercount], ladderend[laddercount]);
                laddercount++;
            } else {
                    squares[count] = new Square(false);
                }
            }
        return squares;
    }

    public String printBoardArray(Square[] squares, Player[] players) {
        String[] boardArray = new String[squares.length];

        //START add Squares, Snakes and Ladders to board
        for(int i=0; i < boardArray.length; i++) {
            if (squares[i] instanceof Snake){
                boardArray[i] = "["+(squares[i].getEnd()+1)+"<-"+(i+1);
            } else if(squares[i] instanceof Ladder ) {
                boardArray[i] = "["+(i+1)+"->"+(squares[i].getEnd()+1);
            } else {
                boardArray[i] = "["+(i+1);
            }
        }
        //END add Squares Snakes and Ladders to board

        //START add Players
        for(Player player : players) {
            boardArray[player.getPosition()] += "<"+player.getName()+">";
        }

        //set closing brackets
        for(int i=0; i < boardArray.length; i++) {
            boardArray[i] += "]";
        }

        //print BoardArray
        StringBuilder builder = new StringBuilder();
        for (String value : boardArray) {
            builder.append(value);
        }
        String strArray = builder.toString();
        return strArray;
        //print BoardArray
    }
}



