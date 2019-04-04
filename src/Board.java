import java.util.ArrayList;

class Board {
    /**
     * Board Class
     */

    private int counter = 0;

    Player white;
    Player black;
    String[][] boardArrayForDisplay;

    public Board() {
        white = new Player('w');
        black = new Player('b');
    }

    public ChessPiece getEnemyPieceFromLocation(char player, Location loc) {
        if (player == 'w') {
            return black.getPieceFromLocation(loc);        
        }
        else {
            return white.getPieceFromLocation(loc);
        }
    } 

    public ChessPiece[] getAllPiecesInBoard() {

        ArrayList<ChessPiece> temporary = new ArrayList<ChessPiece>();
        for (int i = 0; i < 16; i++) {
            if (white.pieces[i].getStatus() == 1) {
                temporary.add(white.pieces[i]);
            }
            if (black.pieces[i].getStatus() == 1) {
                temporary.add(black.pieces[i]);
            }
        }

        ChessPiece[] alivePieces = new ChessPiece[temporary.size()];
        alivePieces = temporary.toArray(alivePieces);
        return alivePieces;
    }

    public boolean isPathClear(Location[] path) {
        // if there is no obstacle return true
        if (path == null) {
            return true;
        }
        else {
            ChessPiece[] allPieces = getAllPiecesInBoard();
            for (ChessPiece tempPiece : allPieces) {
                for (Location tempLocation : path) {
                    if (tempLocation.equals(tempPiece.getLocation())) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public char isTargetClear(Location targetLocation) {
        // b, w, 0
        ChessPiece[] whitePieces = white.getAllPiecesInPlayer();
        ChessPiece[] blackPieces = black.getAllPiecesInPlayer();
        
        for (ChessPiece tempPiece : whitePieces){
            if (targetLocation.equals(tempPiece.getLocation())){
                return 'w';
            }
        }
        for (ChessPiece tempPiece : blackPieces){
            if (targetLocation.equals(tempPiece.getLocation())){
                return 'b';
            }
        }
        return '0';
    }

    // movePawn
    public void movePawn(Player player, String piece, Location targetLocation) throws Exception {
        
        if (player.getPieceFromString(piece) instanceof Pawn) {
            if (Math.abs(targetLocation.getX() - player.getPieceFromString(piece).getLocation().getX()) == 1) {
                if (isTargetClear(targetLocation) == '0') {
                    // illegal move
                }
                else {
                    move(player, piece, targetLocation);
                }
            }
        }
    }



    // pawn's firstMove should change to 1
    public void move(Player player, String piece, Location targetLocation) throws Exception {

        // if the turn is the player's, continue
        if ((counter % 2 == 0 && player.getColour() == 'w') || (counter % 2 == 1 && player.getColour() == 'b')) {
                 
            // if the move is legal for the piece
            if (player.getPieceFromString(piece).isPossible(targetLocation) == true) {
                    
                    // if there is no obstacles, continue
                    if (isPathClear(player.getPieceFromString(piece).getPath(targetLocation))) {
                
                        // if target is same colour, error
                        if (isTargetClear(targetLocation) == player.getColour()) {
                            // illegal move
                            throw new Exception("targetIsSameColour");
                        }
                        
                        // if target is different colour, kill piece
                        else if (isTargetClear(targetLocation) != player.getColour() && isTargetClear(targetLocation) != '0') {
                            getEnemyPieceFromLocation(player.getColour(), targetLocation).kill(); 
                        }
                       
                        // if target is empty, move
                        else {
                            player.getPieceFromString(piece).setLocation(targetLocation); // set location
                        }
                    }

                    else {
                        // illegal move
                        throw new Exception("pathIsNotClear");
                    }
            }
            
            else {
                // illegal move
                throw new Exception("invalidMove");
            }   
        }
        
        else {
            // illegal move
            throw new Exception("opponentTurn");
        }
    }
    
   /* public void display() {
        boardArrayForDisplay = new String[8][8];
        Location newLoc;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                newLoc = new Location(i,j);
                if (white.getPieceFromLocation(newLoc) instanceof ChessPiece) {
                    boardArrayForDisplay[i][j] = "White " + white.getPieceFromLocation(newLoc);
                }
                else if (black.getPieceFromLocation(newLoc) instanceof ChessPiece) { 
                    boardArrayForDisplay[i][j] = "Black " + white.getPieceFromLocation(newLoc);
                }
                else {(boardArrayForDisplay[i][j]);
            }
            System.out.println();
        }
    }
}

                    boardArrayForDisplay[i][j] = " x ";
                }      
            }
        }
        
        System.out.println("--- BOARD ---\n");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.printf(boardArrayForDisplay[i][j]);
            }
            System.out.println();
        }

    } */

    public void display() {
        /* TODO:        
         * Board display yonu ve sirasi duzelt.
         * if null ise'yi check et
         */
        boardArrayForDisplay = new String[8][8];
        for (ChessPiece tempPiece : getAllPiecesInBoard()) {
            boardArrayForDisplay[tempPiece.getLocation().getX()][tempPiece.getLocation().getY()] = tempPiece.toString();
        }

        System.out.println("--- BOARD ---\n");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (boardArrayForDisplay[i][j] != "") System.out.printf(boardArrayForDisplay[i][j]);
                else System.out.println(" x ");
            }
            System.out.println();
        }
    }
}
