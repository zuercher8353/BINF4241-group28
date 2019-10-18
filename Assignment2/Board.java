import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Board {
    private int boardsize = 8;

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
        chessBoard[7][4] = new King(false);

        //START initialize figures
    }


    public void printBoard() {
        System.out.print("   a    b    c    d    e    f    g    h\n"); //x axis
        for (int i = 0; i < boardsize; i++) {
            System.out.print(i + " ");            //y axis (on the left)
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
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void removeFigure(int i, int j, Player player) {
        Object object = chessBoard[i][j];
        player.addEatenPiece(object);
        chessBoard[i][j] = null;
    }

    //TODO @Janosch killfigure bauen
    public void killFigure(int[] killPosition, Player player) {
        //int killPosX =
    }

    //TODO @Janosch moveFigure bauen
    public void moveFigure(int[] moveArrayINT) {
        int startX = moveArrayINT[0];
        int startY = moveArrayINT[1];
        int endX = moveArrayINT[2];
        int endY = moveArrayINT[3];
        if (!(chessBoard[startX][startY] == null)) {
            Object temp = chessBoard[startX][startY];
            chessBoard[startX][startY] = null;
            chessBoard[endX][endY] = temp;
        } else {
            System.out.println("no figure to move");
        }
    }

    //TODO @Jonas findKing indices?
    public King findKing(String color) {
        //TODO do i need to return the indices?
        for (Object object : chessBoard) {
            if (object.getClass() == King.class) {
                King king = (King) object;
                if(king.iswhite()) {
                    return king;
                }
            }
        }
        System.out.println("no king found");
        return null;
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
        if(endField != null){
            if (startFieldColor == endFieldColor) {
                System.out.println("Endfield is occupied by own figure");
                return false;
            }
            else {
                System.out.println(endField.getClass().getName() + "is getting eating");
            }
        }

        moveFigure(array);

        return true;
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
                    return true;
                }

            }
        }
        return false;
    }


    public int[] kingPosition(Player player){
        int[] kingPosition = new int[2];

        for (int x = 0; x < boardsize; x++) {
            for (int y = 0; y < boardsize; y++) {
                if(chessBoard[x][y] != null){
                    if (chessBoard[x][y].getClass() == King.class) {
                        King kingPositionObject = (King) chessBoard[x][y];
                        if (kingPositionObject.iswhite() == player.isPlayerWhite()) {
                            kingPosition[0] = x;
                            kingPosition[1] = y;
                            return kingPosition;
                        }
                }}
            }
        }
        return kingPosition;
    }

    public boolean tryIsCheck(int[] array, Player player) {
        boolean startFieldColor;
        boolean endFieldColor;
        Object startField = chessBoard[array[0]][array[1]];
        Object endField = chessBoard[array[2]][array[3]];

        if (startField == null) {                                              //figur auf dem Anfangspunkt
            return false;
        }
        else if(startField.getClass() == Bishop.class) {
            Bishop startField1 = (Bishop)startField;
            startFieldColor= startField1.iswhite();
            if(!isLegalPath(startField1, array)){
                return false;
            }
        }
        else if(startField.getClass() == King.class) {
            King startField1 = (King)startField;
            startFieldColor= startField1.iswhite();
            if(!isLegalPath(startField1, array)){
                return false;
            }
        }
        else if(startField.getClass() == Queen.class) {
            Queen startField1 = (Queen)startField;
            startFieldColor= startField1.iswhite();
            if(!isLegalPath(startField1, array)){
                return false;
            }
        }
        else if(startField.getClass() == Rock.class) {
            Rock startField1 = (Rock)startField;
            startFieldColor= startField1.iswhite();
            if(!isLegalPath(startField1, array)){
                return false;
            }
        }
        else if(startField.getClass() == Knight.class) {
            Knight startField1 = (Knight)startField;
            startFieldColor= startField1.iswhite();
            if(!isLegalPath(startField1, array)){
                return false;
            }
        }
        else if(startField.getClass() == Pawn.class) {
            Pawn startField1 = (Pawn)startField;
            startFieldColor= startField1.iswhite();
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
        //eigene Figur?
        if (startFieldColor!= player.isPlayerWhite()) {
            return false;
        }
        //check if endfield is not own figur
        if(endField != null){
            if (startFieldColor == endFieldColor) {
                return false;
            }
        }
        return true;
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
