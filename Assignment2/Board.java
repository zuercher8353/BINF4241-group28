import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Board {
    private int boardsize = 8;
    private int[] positionFigureCheck = new int[2];
    private int[] lastMove = new int[4];
    private int[] lastRealMove = new int[4];
    private Object lastdeleted;
    private boolean lastHasMoved = true;

    private Object[][] chessBoard = new Object[boardsize][boardsize];

    public Board() {
        for (int i = 0; i < boardsize; i++) {
            for (int j = 0; i < boardsize; i++)
                chessBoard[i][j] = null;
        }

        //START initialize figures, black at the top, white at the bottom

        //init all pawns
        for (int k = 0; k < boardsize; k++) {
            chessBoard[1][k] = new Pawn(false);
            chessBoard[6][k] = new Pawn(true);
        }




        //init towers
        chessBoard[0][0] = new Rock(false);
        chessBoard[0][7] = new Rock(false);
        chessBoard[7][0] = new Rock(true);
        chessBoard[7][7] = new Rock(true);

        //init knights
        chessBoard[0][1] = new Knight(false);
        chessBoard[0][6] = new Knight(false);
        chessBoard[7][1] = new Knight(true);
        chessBoard[7][6] = new Knight(true);


        //init bishops
        chessBoard[0][2] = new Bishop(false);
        chessBoard[0][5] = new Bishop(false);
        chessBoard[7][2] = new Bishop(true);
        chessBoard[7][5] = new Bishop(true);

        //init queen
        chessBoard[0][3] = new Queen(false);
        chessBoard[7][3] = new Queen(true);


        //init king
        chessBoard[0][4] = new King(false);
        chessBoard[7][4] = new King(true);

        //END initialize figures
    }

    public void printBoard() {
        System.out.print("   a    b    c    d    e    f    g    h\n"); //character x axis on top

        int yLabel = 8; //for numeric y axis
        for (int i = 0; i < boardsize; i++) {
            System.out.print((yLabel) + " ");            //numeric y axis (on the left)
            for (int j = 0; j < boardsize; j++) {
                if (chessBoard[i][j] == null) {
                    System.out.print("[  ] ");
                } else {
                    if (chessBoard[i][j].getClass() == Bishop.class) {
                        Bishop bishop = (Bishop) chessBoard[i][j];
                        if (bishop.iswhite()) {
                            System.out.print("[W" + bishop.getToken() + "] ");
                        } else {
                            System.out.print("[B" + bishop.getToken() + "] ");
                        }

                    } else if (chessBoard[i][j].getClass() == King.class) {
                        King king = (King) chessBoard[i][j];
                        if (king.iswhite()) {
                            System.out.print("[W" + king.getToken() + "] ");
                        } else {
                            System.out.print("[B" + king.getToken() + "] ");
                        }
                    } else if (chessBoard[i][j].getClass() == Knight.class) {
                        Knight knight = (Knight) chessBoard[i][j];
                        if (knight.iswhite()) {
                            System.out.print("[W" + knight.getToken() + "] ");
                        } else {
                            System.out.print("[B" + knight.getToken() + "] ");
                        }
                    } else if (chessBoard[i][j].getClass() == Queen.class) {
                        Queen queen = (Queen) chessBoard[i][j];
                        if (queen.iswhite()) {
                            System.out.print("[W" + queen.getToken() + "] ");
                        } else {
                            System.out.print("[B" + queen.getToken() + "] ");
                        }
                    } else if (chessBoard[i][j].getClass() == Pawn.class) {
                        Pawn pawn = (Pawn) chessBoard[i][j];
                        if (pawn.iswhite()) {
                            System.out.print("[W" + pawn.getToken() + "] ");
                        } else {
                            System.out.print("[B" + pawn.getToken() + "] ");
                        }
                    } else if (chessBoard[i][j].getClass() == Rock.class) {
                        Rock rock = (Rock) chessBoard[i][j];
                        if (rock.iswhite()) {
                            System.out.print("[W" + rock.getToken() + "] ");
                        } else {
                            System.out.print("[B" + rock.getToken() + "] ");
                        }
                    }

                }
            }
            System.out.print(" (" + i + ") \n");
            yLabel = yLabel - 1;
        }
        System.out.print("\n");

    }

    public void removeFigure(int i, int j, Player player) {
        Object object = chessBoard[i][j];
        player.addEatenPiece(object);
    }

    public void moveFigure(int[] moveArrayINT) {

        int startX = moveArrayINT[0];
        int startY = moveArrayINT[1];
        int endX = moveArrayINT[2];
        int endY = moveArrayINT[3];
        lastMove = moveArrayINT.clone();
        if (!(chessBoard[startX][startY] == null)) {
            if(chessBoard[startX][startY].getClass() == King.class) {
                King ObjectStartField = (King)chessBoard[startX][startY];
                if(ObjectStartField.getHasmoved() == false){
                    lastHasMoved = false;
                    ObjectStartField.setHasMoved(true);
                }

            }
            else if(chessBoard[startX][startY].getClass() == Rock.class) {
                Rock ObjectStartField = (Rock) chessBoard[startX][startY];
                if(ObjectStartField.getHasmoved() == false){
                    lastHasMoved = false;
                    ObjectStartField.setHasMoved(true);
                }
            }
            else if(chessBoard[startX][startY].getClass() == Pawn.class) {
                Pawn ObjectStartField = (Pawn) chessBoard[startX][startY];
                if(ObjectStartField.getHasmoved() == false){
                    lastHasMoved = false;
                    ObjectStartField.setHasMoved(true);
                }
            }
            Object temp = chessBoard[startX][startY];
            chessBoard[startX][startY] = null;
            if (chessBoard[endX][endY] != null) {
                lastdeleted = chessBoard[endX][endY];
            }
            else{
                lastdeleted = null;
            }
            chessBoard[endX][endY] = temp;
        } else {
            System.out.println("no figure to move");
        }
    }


    public void undoMoveFigure(){
        int startX = lastMove[2];
        int startY = lastMove[3];
        int endX = lastMove[0];
        int endY = lastMove[1];
        if (!(chessBoard[startX][startY] == null)) {
            Object temp = chessBoard[startX][startY];
            if(chessBoard[startX][startY].getClass() == King.class) {
                King ObjectStartField = (King)chessBoard[startX][startY];
                if(!lastHasMoved){
                    lastHasMoved = true;
                    ObjectStartField.setHasMoved(false);
                }
            }
            else if(chessBoard[startX][startY].getClass() == Rock.class) {
                Rock ObjectStartField = (Rock) chessBoard[startX][startY];
                if(!lastHasMoved){
                    lastHasMoved = true;
                    ObjectStartField.setHasMoved(false);
                }
            }
            else if(chessBoard[startX][startY].getClass() == Pawn.class) {
                Pawn ObjectStartField = (Pawn) chessBoard[startX][startY];
                if(!lastHasMoved){
                    lastHasMoved = true;
                    ObjectStartField.setHasMoved(false);
                }
            }
            if(lastdeleted != null){
                chessBoard[endX][endY] = temp;
                chessBoard[startX][startY] = lastdeleted;
                lastdeleted = null;
            }
            else {
                chessBoard[endX][endY] = temp;
                chessBoard[startX][startY] = null;
            }
        }
        else {
            System.out.println("no figure to move");
        }
    }

    public boolean isCheckMated(Player player, Players players){
        isCheck(player, players);
        int[] FigureDoesCheck = positionFigureCheck.clone();
        int[] kingPosition = kingPosition(player);
        //check if King can move out of Check
        int[] kingMoves = new int[4];
        kingMoves[0] = kingPosition[0];
        kingMoves[1] = kingPosition[1];
        for(int i= 1; i>=-1; i -=2){
            kingMoves[2] = kingPosition[0] + i;
            for(int j= 1; j>=-1; j -=2){
                kingMoves[3] = kingPosition[1] + j;
                if(kingMoves[2] >= 0 && kingMoves[2] <=7 && kingMoves[3] >= 0 && kingMoves[3] <=7) {
                    if (tryIsCheck(kingMoves, player)) {
                        moveFigure(kingMoves);
                        if (!isCheck(player, players)) {
                            undoMoveFigure();
                            System.out.println("your king can move out of the way");
                            return false;
                        } else {
                            undoMoveFigure();
                        }
                    }
                }
            }
        }
        //check if figures that checks King, can be killed and that after this it isn`t check anymore
        int[] killFigure = new int[4];
        killFigure[2] = FigureDoesCheck[0];
        killFigure[3] = FigureDoesCheck[1];
        for (int x = 0; x < boardsize; x++) {
            killFigure[0] = x;
            for (int y = 0; y < boardsize; y++) {
                killFigure[1] = y;
                if(tryIsCheck(killFigure, player)){
                    moveFigure(killFigure);
                    if(!isCheck(player, players)){
                        undoMoveFigure();
                        System.out.println("you can kill figure");
                        return false;
                    }
                    else {
                        undoMoveFigure(); }
                }

            }
        }

        //check if we can do something in the way, check if still Check
        ArrayList<Integer> path = new ArrayList<>();
        Object startField = chessBoard[FigureDoesCheck[0]][FigureDoesCheck[1]];
        int[]putInWay = new int[4];
        putInWay[0]= FigureDoesCheck[0] ;
        putInWay[1]= FigureDoesCheck[1] ;
        putInWay[2]= kingPosition[0];
        putInWay[3]= kingPosition[1];

        if(startField.getClass() == Bishop.class) {
            Bishop startField1 = (Bishop)startField;
            path = startField1.path(putInWay);
        }
        else if(startField.getClass() == King.class) {
            King startField1 = (King)startField;
            path = startField1.path(putInWay);
        }
        else if(startField.getClass() == Queen.class) {
            Queen startField1 = (Queen)startField;
            path = startField1.path(putInWay);
        }
        else if(startField.getClass() == Rock.class) {
            Rock startField1 = (Rock)startField;
            path = startField1.path(putInWay);
        }
        else if(startField.getClass() == Knight.class) {
            Knight startField1 = (Knight)startField;
            path = startField1.path(putInWay);
        }
        else if(startField.getClass() == Pawn.class) {
            Pawn startField1 = (Pawn) startField;
            path = startField1.path(putInWay);
        }

        int x = path.size();
        for (int i = 0; i < x; i += 2) {
            putInWay[2] = path.get(i);
            putInWay[3] = path.get(i+1);
            for (int k = 0; k < boardsize; k++) {
                putInWay[0] = k;
                for (int l = 0; l < boardsize; l++) {
                    putInWay[1] = l;
                    if (tryIsCheck(putInWay, player)) {
                        moveFigure(putInWay);
                        if (!isCheck(player, players)) {
                            undoMoveFigure();
                            System.out.println("you can put something in the way");
                            return false;
                        } else {
                            undoMoveFigure();
                        }
                    }

                }
            }
        }

        return true;
    }

    public boolean tryMove(ArrayList list, Player player, Players players) {
        boolean startFieldColor;
        boolean endFieldColor;
        String token;

        int[] array = new int[4];

        for(int i=1; i <= 4; i++){
            array[i-1] = (Integer) list.get(i);
        }

        String figurtyp = list.get(0).toString();
        Object startField = chessBoard[array[0]][array[1]];
        Object endField = chessBoard[array[2]][array[3]];

        if (startField == null) {                                              //figur auf dem Anfangspunkt
            System.out.println("The chosen startfield is empty");
            return false;
        }
        else if(startField.getClass() == Bishop.class) {
            Bishop startField1 = (Bishop)startField;
            startFieldColor= startField1.iswhite();
            token = startField1.getToken();
            if(!isLegalPath(startField1, array)){
                return false;
            }
        }
        else if(startField.getClass() == King.class) {
            King startField1 = (King)startField;
            startFieldColor= startField1.iswhite();
            token = startField1.getToken();
            if(!isLegalPath(startField1, array)){
                return false;
            }
        }
        else if(startField.getClass() == Queen.class) {
            Queen startField1 = (Queen)startField;
            startFieldColor= startField1.iswhite();
            token = startField1.getToken();
            if(!isLegalPath(startField1, array)){
                return false;
            }
        }
        else if(startField.getClass() == Rock.class) {
            Rock startField1 = (Rock)startField;
            startFieldColor= startField1.iswhite();
            token = startField1.getToken();
            if(!isLegalPath(startField1, array)){
                return false;
            }
        }
        else if(startField.getClass() == Knight.class) {
            Knight startField1 = (Knight)startField;
            startFieldColor= startField1.iswhite();
            token = startField1.getToken();
            if(!isLegalPath(startField1, array)){
                return false;
            }
        }
        else if(startField.getClass() == Pawn.class) {
            Pawn startField1 = (Pawn)startField;
            startFieldColor= startField1.iswhite();
            token = startField1.getToken();
            if(!isLegalPath(startField1, array)){
                return false;
            }
            if(Math.abs(array[2]-array[0]) == 1 && Math.abs(array[3]-array[1]) == 1){       //check if pawn is allowed to move transversal
                if(endField == null){
                    System.out.println("The figure you chose can't move like this");
                    return false;
                }
            }
            else{                                                                           //check if endfield is empty, cause pawn can only move forward if endfield empty
                if(endField != null){
                    System.out.println("The figure you chose can't move like this");
                    return false;
                }
            }
        }
        else {
            token = null;
            startFieldColor = true; //testen ob falsche frabe startfigur richtig erkannt wird
        }
        if(endField == null){
            endFieldColor = true;
        }
        else if(endField.getClass() == Bishop.class) {
            Bishop endField1 = (Bishop)endField;
            endFieldColor = endField1.iswhite();
        }
        else if(endField.getClass() == King.class) {
            King endField1 = (King)endField;
            endFieldColor = endField1.iswhite();
        }
        else if(endField.getClass() == Queen.class) {
            Queen endField1 = (Queen)endField;
            endFieldColor = endField1.iswhite();
        }
        else if(endField.getClass() == Rock.class) {
            Rock endField1 = (Rock)endField;
            endFieldColor = endField1.iswhite();
        }
        else if(endField.getClass() == Knight.class) {
            Knight endField1 = (Knight)endField;
            endFieldColor = endField1.iswhite();
        }
        else if(endField.getClass() == Pawn.class) {
            Pawn endField1 = (Pawn)endField;
            endFieldColor = endField1.iswhite();
        }
        else{
            endFieldColor = true;
        }
        //Figur at Startfield == Figurtyp of input
        if(!figurtyp.equals(token)){
            System.out.println("The input figuretyp doesn`t match with the figuretyp that is on the startfield");
            return false;
        }
            //eigene Figur?
        if (startFieldColor!= player.isPlayerWhite()) {
            System.out.println("The figure that you try to move is not yours");
            return false;
        }
        //check if endfield is not own figur
        moveFigure(array);
        if(isCheck(player, players)){
            undoMoveFigure();
            System.out.println("Your committing Kingsuicid");
            return false;
        }
        else{
            undoMoveFigure();}

        if(endField != null){
            if (startFieldColor == endFieldColor) {
                System.out.println("Endfield is occupied by own figure");
                return false;
            }
            else {
                Player otherplayer = players.otherPlayer(player);
                removeFigure(array[2], array[3], otherplayer);  //soltte nicht gemacht werden wenn Kingsuicid
                System.out.println(endField.getClass().getName() + " is getting eaten");
                moveFigure(array);
            }
        }
        else {
            moveFigure(array);
        }
        lastRealMove = array;

        return true;

        }

    public boolean promoteFigure(ArrayList moveArray, Player player, Players players) {
        boolean legalPromotion = false;

        int startX = (Integer) moveArray.get(1);
        int startY = (Integer) moveArray.get(2);
        int endX = (Integer) moveArray.get(3);
        int endY = (Integer) moveArray.get(4);
        char promoteTo = (Character) moveArray.get(5);
        //Promoting Token is valid since checked in Reader

        //START check if start field is not empty and occupied by a Pawn
        if (!(chessBoard[startX][startY] == null)) {
            if (chessBoard[startX][startY].getClass() == Pawn.class) {
                if (player.isPlayerWhite()) {
                    Pawn pawn = new Pawn(true);
                } else {
                    Pawn pawn = new Pawn(false);
                }
            } else {
                System.out.println("Promotion: Figure to promote must be a pawn");
                return legalPromotion;
            }
        } else {
            System.out.println("Promotion: Field chosen is empty");
            return legalPromotion;
        }
        //END check if start field is not empty and occupied by a Pawn

        //Check if Pawn target is on upper or lower board edge
        if ((player.isPlayerWhite() && endX != 0) || (!(player.isPlayerWhite()) && endX != 8)) {
            System.out.println("Pawn cannot be promoted OR is not yours");
            return legalPromotion;
        }


        //IF its a Pawn and Promotion Token is valid, move Figure and promote
        if(tryMove(moveArray,player,players)) {
            if ((player.isPlayerWhite() && endX == 0)) {
                if (promoteTo == 'B') {
                    chessBoard[endX][endY] = new Bishop(true);
                } else if (promoteTo == 'N') {
                    chessBoard[endX][endY] = new Knight(true);
                } else if (promoteTo == 'P') {
                    chessBoard[endX][endY] = new Pawn(true);
                } else if (promoteTo == 'Q') {
                    chessBoard[endX][endY] = new Queen(true);
                } else if (promoteTo == 'R') {
                    chessBoard[endX][endY] = new Rock(true);
                }
                legalPromotion = true;
            } else if ((!(player.isPlayerWhite()) && endX == 8)) {

                if (promoteTo == 'B') {
                    chessBoard[endX][endY] = new Bishop(false);
                } else if (promoteTo == 'N') {
                    chessBoard[endX][endY] = new Knight(false);
                } else if (promoteTo == 'P') {
                    chessBoard[endX][endY] = new Pawn(false);
                } else if (promoteTo == 'Q') {
                    chessBoard[endX][endY] = new Queen(false);
                } else if (promoteTo == 'R') {
                    chessBoard[endX][endY] = new Rock(false);
                }
                legalPromotion = true;
            }
        }
        else {
            System.out.println("Move of Promotion not possible");
            legalPromotion = false;
        }
        return legalPromotion;
    }

    //supress output of this function if used in isCheck or delet it here and add to tryMove
    public boolean isLegalPath(Figur startField, int[] array){

        //check if figur can move like this
        if (!startField.islegal(array)) {
            //System.out.println("The figure you chose can't move like this");
            return false;
        }
        //check if path between start and end is empty
        ArrayList<Integer> path = startField.path(array);
        int x = path.size();
        for (int i = 0; i < x; i += 2) {
            if (chessBoard[path.get(i)][path.get(i + 1)] != null) {
                //System.out.println("there is a figure in your way");
                return false;
            }
        }
        return true;
    }

    //player is the player who has the next turn, check must be checked before he takes a turn
    public boolean isCheck(Player player, Players players){
        int[] kingPosition = kingPosition(player);
        int[] checkKingArray = new int[4];
        checkKingArray[2] = kingPosition[0];
        checkKingArray[3] = kingPosition[1];
        Player otherPlayer = players.otherPlayer(player);
        for (int x = 0; x < boardsize; x++) {
            checkKingArray[0] = x;
            for (int y = 0; y < boardsize; y++) {
                checkKingArray[1] = y;
                if(tryIsCheck(checkKingArray, otherPlayer)){         //player should be the other player(not the one inserted into the function), (the player which has moved before)
                    positionFigureCheck[0] = x;
                    positionFigureCheck[1] = y;
                    return true;
                }
            }
        }
        return false;
    }


    public boolean shortRochade(Player player, Players players){
        int[] kingPos = kingPosition(player);
        int x;
        King kingObj = (King) chessBoard[kingPos[0]][kingPos[1]];
        if (isCheck(player, players)){
            System.out.println("You are in check");
            return false;
        }
        if (kingObj.getHasmoved()){
            System.out.println("King has already moved. No castling possible");
            return false;
        }
        for (int y = kingPos[1]+1; y <= 6; y++){
            if (chessBoard[kingPos[0]][y] != null){
                System.out.println("Other figures are in the way");
                return false;
            }
        }
        if (player.isPlayerWhite()) {
            x = 7;
        }else{
            x = 0;
        }
            if(chessBoard[x][7] !=  null) {
                if (!(chessBoard[x][7].getClass() == Rock.class)) {
                    System.out.println("Rock is not in the right place.");
                    return false;
                } else {
                    Rock rockObj = (Rock) chessBoard[x][7];
                    if (rockObj.getHasmoved()) {
                        System.out.println("Rock has already moved. No castling possible.");
                        return false;
                    } else {
                        int[] moveArray = new int[4];
                        for (int y = kingPos[1]+1; y < 7; y++) {
                            moveArray[0] = kingPos[0];
                            moveArray[1] = kingPos[1];
                            moveArray[2] = kingPos[0];
                            moveArray[3] = y;
                            moveFigure(moveArray);


                            if (isCheck(player, players)) {
                                undoMoveFigure();
                                System.out.println("King is checked. No castling possible");
                                return false;
                            }
                            undoMoveFigure();
                        }
                        moveFigure(moveArray);
                        int[] moveArrayRock = {x, 7, x, 5};
                        moveFigure(moveArrayRock);
                    }

                }
            }


        return true;

    }

    public boolean longRochade(Player player, Players players) {
        int[] kingPos = kingPosition(player);
        int x;
        King kingObj = (King) chessBoard[kingPos[0]][kingPos[1]];
        if (isCheck(player, players)){
            System.out.println("You are in check");
            return false;
        }
        if (kingObj.getHasmoved()) {
            System.out.println("King has already moved. No castling possible");
            return false;
        }
        for (int y = kingPos[1] - 1; y > 0; y--) {
            if (chessBoard[kingPos[0]][y] != null) {
                System.out.println("Other figures are in the way");
                return false;
            }
        }
        if (player.isPlayerWhite()) {
            x = 7;
        } else {
            x = 0;
        }
        if (chessBoard[x][0] != null) {
            if (!(chessBoard[x][7].getClass() == Rock.class)) {
                System.out.println("Rock is not in the right place.");
                return false;
            } else {
                Rock rockObj = (Rock) chessBoard[x][0];
                if (rockObj.getHasmoved()) {
                    System.out.println("Rock has already moved. No castling possible.");
                    return false;
                } else {
                    int[] moveArray = new int[4];
                    for (int y = kingPos[1] - 1; y > 1; y--) {
                        moveArray[0] = kingPos[0];
                        moveArray[1] = kingPos[1];
                        moveArray[2] = kingPos[0];
                        moveArray[3] = y;
                        moveFigure(moveArray);


                        if (isCheck(player, players)) {
                            undoMoveFigure();
                            System.out.println("King is checked. No castling possible");
                            return false;
                        }
                        undoMoveFigure();
                    }
                    moveFigure(moveArray);
                    int[] moveArrayRock = {x, 0, x, 3};
                    moveFigure(moveArrayRock);
                }

            }
        }
        return true;
    }


        public int[] kingPosition (Player player){
            int[] kingPosition = new int[2];

            for (int x = 0; x < boardsize; x++) {
                for (int y = 0; y < boardsize; y++) {
                    if (chessBoard[x][y] != null) {
                        if (chessBoard[x][y].getClass() == King.class) {
                            King kingPositionObject = (King) chessBoard[x][y];
                            if (kingPositionObject.iswhite() == player.isPlayerWhite()) {
                                kingPosition[0] = x;
                                kingPosition[1] = y;
                                return kingPosition;
                            }
                        }
                    }
                }
            }
            return kingPosition;
        }

        //gleiche wie trymove(), ohne prints und ohne typ am anfang von Arraylist, ohne move
        public boolean tryIsCheck ( int[] array, Player player){
            boolean startFieldColor;
            boolean endFieldColor;
            Object startField = chessBoard[array[0]][array[1]];
            Object endField = chessBoard[array[2]][array[3]];

            if (startField == null) {                                              //figur auf dem Anfangspunkt
                return false;
            } else if (startField.getClass() == Bishop.class) {
                Bishop startField1 = (Bishop) startField;
                startFieldColor = startField1.iswhite();
                if (!isLegalPath(startField1, array)) {
                    return false;
                }
            } else if (startField.getClass() == King.class) {
                King startField1 = (King) startField;
                startFieldColor = startField1.iswhite();
                if (!isLegalPath(startField1, array)) {
                    return false;
                }
            } else if (startField.getClass() == Queen.class) {
                Queen startField1 = (Queen) startField;
                startFieldColor = startField1.iswhite();
                if (!isLegalPath(startField1, array)) {
                    return false;
                }
            } else if (startField.getClass() == Rock.class) {
                Rock startField1 = (Rock) startField;
                startFieldColor = startField1.iswhite();
                if (!isLegalPath(startField1, array)) {
                    return false;
                }
            } else if (startField.getClass() == Knight.class) {
                Knight startField1 = (Knight) startField;
                startFieldColor = startField1.iswhite();
                if (!isLegalPath(startField1, array)) {
                    return false;
                }
            } else if (startField.getClass() == Pawn.class) {
                Pawn startField1 = (Pawn) startField;
                startFieldColor = startField1.iswhite();
                if (!isLegalPath(startField1, array)) {
                    return false;
                }
                if (Math.abs(array[2] - array[0]) == 1 && Math.abs(array[3] - array[1]) == 1) {       //check if pawn is allowed to move transversal
                    if (endField == null) {
                        return false;
                    }
                } else {                                                                           //check if endfield is empty, cause pawn can only move forward if endfield empty
                    if (endField != null) {
                        return false;
                    }
                }
            } else {
                startFieldColor = true; //testen ob falsche frabe startfigur richtig erkannt wird
            }
            if (endField == null) {
                endFieldColor = true;
            } else if (endField.getClass() == Bishop.class) {
                Bishop endField1 = (Bishop) endField;
                endFieldColor = endField1.iswhite();
            } else if (endField.getClass() == King.class) {
                King endField1 = (King) endField;
                endFieldColor = endField1.iswhite();
            } else if (endField.getClass() == Queen.class) {
                Queen endField1 = (Queen) endField;
                endFieldColor = endField1.iswhite();
            } else if (endField.getClass() == Rock.class) {
                Rock endField1 = (Rock) endField;
                endFieldColor = endField1.iswhite();
            } else if (endField.getClass() == Knight.class) {
                Knight endField1 = (Knight) endField;
                endFieldColor = endField1.iswhite();
            } else if (endField.getClass() == Pawn.class) {
                Pawn endField1 = (Pawn) endField;
                endFieldColor = endField1.iswhite();
            } else {
                endFieldColor = true;
            }
            //eigene Figur?
            if (startFieldColor != player.isPlayerWhite()) {
                return false;
            }
            //check if endfield is not own figur
            if (endField != null) {
                if (startFieldColor == endFieldColor) {
                    return false;
                }
            }
            return true;
        }



    public boolean enPassant(ArrayList movearray, Player player, Players players){
        int endX = lastRealMove[2];
        int endY = lastRealMove[3];
        int[] tryEnPassant = new int[4];
        ArrayList<Integer> path = new ArrayList<>();
        tryEnPassant[0] = (Integer) movearray.get(1);
        tryEnPassant[1] = (Integer) movearray.get(2);
        tryEnPassant[2] = (Integer) movearray.get(3);
        tryEnPassant[3] = (Integer) movearray.get(4);

        //check if char at the beginning is = P;
        String figuretyp = movearray.get(0).toString();
        if(!(figuretyp.equals("P"))){
            System.out.println("The first letter of the input must be P for en passant");
            return false;
        }

        if(chessBoard[endX][endY] != null) {
            if (chessBoard[endX][endY].getClass() == Pawn.class) {
                Pawn movedPawn = (Pawn) chessBoard[endX][endY];
                path = movedPawn.path(lastRealMove);
                if(path.size() == 2) {
                    if(path.get(0) == tryEnPassant[2] && path.get(1) == tryEnPassant[3]) {
                        if (chessBoard[tryEnPassant[0]][tryEnPassant[1]].getClass() == Pawn.class) {
                            Pawn killerPawn = (Pawn) chessBoard[tryEnPassant[0]][tryEnPassant[1]];
                            if (killerPawn.iswhite() == player.isPlayerWhite()) {
                                if (isLegalPath(killerPawn, tryEnPassant)) {
                                    Player otherPlayer = players.otherPlayer(player);
                                    removeFigure(endX, endY, otherPlayer);
                                    moveFigure(tryEnPassant);
                                    chessBoard[endX][endY] = null;
                                    return true;
                                }
                            }
                        }
                    }


                }
                else{
                    System.out.println("Pawn was not moved 2 fields");
                    return false;
                }
            }
            else{
                System.out.println("Last moved Figure is not a Pawn");
                return false;
            }

        }
        System.out.println("Your not allowed to perform en passant");
        return false;
    }




    //public tryMove(inputarray) {
        //figure auf dem input
        // meine Figur?
            //figure move islegal, type of move?
                //figure path? return arraylist path of fields stepped
                    //check if arraylist path is free on board
                        //yes?
                            //is endfield occupied by own figure?
                                //no?
                                    //move
                                //yes?
                                    // dont move, field is occupied by own figure , tell user cannot move
                        //no?
                            //there is a figure in your way
            //figure is not able to move like this, return false
        // nicht meine Figur?

        //return array



}

