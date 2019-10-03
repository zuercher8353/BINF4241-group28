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
        public void initsquare(){
            int count = 1;
            for(i=)

            while(count<=boardsize){
                    boolean multipleplayers = false;
                    if (count == 1){
                            multipleplayers = true;
                    }
                    if(contains(count, snakestart)){
                            //erstelle neus feld snake
                    }
                    else if (contains(count,ladderstart)){
                            //erstelle neues feld ladder
                    }
                    else{
                           Square  = new Square(count, "normal", false, multipleplayers); //number sollte dem count entsprechen, da mit das Feld so heist wie sein index
                    }

                    count++;
            }
        }




}
