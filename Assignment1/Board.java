public class Board {
        private int boardsize = 12;
        private int []snakestart = {11};
        private int []snakeend = {5};
        private int []ladderstart = {2,7};
        private int []ladderend = {6,9};


        private static boolean contains(int key, int []array){
                boolean contain = false;
                for(int i=0; i<array.length; i++){
                        if(key == array[i]){
                                contain = true;
                                break;
                        }
                }
                return contain;
        }
        public void initsquare() {
                int laddercount = 0;
                int snakecount = 0;

                Square[] squares = new Square[boardsize];
                for (int count = 1; count <= boardsize; count++) {
                        if (contains(count, snakestart)) {
                                squares[count-1] = new Snake(count, "Snake", false, false, snakestart[snakecount], snakeend[snakecount]);
                                snakecount++;
                        }
                        else if(contains(count, ladderstart)){
                                squares[count-1] = new Ladder(count, "Ladder", false, false, ladderstart[laddercount], ladderend[laddercount]);
                                laddercount++;
                        }
                        else {
                                if(count == 1){
                                        squares[count-1] = new Square(count, "normal", false, true);}
                                else{
                                squares[count-1] = new Square(count, "normal", false, false);
                        }}
                }
        }}



}
