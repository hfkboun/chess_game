package Game;

import java.util.ArrayList;

class Board {
    /**
     * Board Class
     */

    private int counter = 0;

    Player white;
    Player black;

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
                    if (tempLocation == tempPiece.getLocation()) {
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
        
        for(ChessPiece tempPiece : whitePieces){
            if (targetLocation == tempPiece.getLocation()){
                return 'w';
            }
        }
        for(ChessPiece tempPiece : blackPieces){
            if (targetLocation == tempPiece.getLocation()){
                return 'b';
            }
        }
        return '0';
    }

    public void move(Player player, String piece, Location targetLocation) {
        
        // if the turn is the player's, continue
        if ((counter % 2 == 0 && player.getColour() == 'w') || (counter % 2 == 1 && player.getColour() == 'b')) {
                 
            // if the move is legal for the piece
            if (player.getPieceFromString(piece).isPossible(targetLocation) == true) {
                    
                    // if there is no obstacles, continue
                    if (isPathClear(player.getPieceFromString(piece).getPath(targetLocation))) {
                        
                        // if target is same colour, error
                        if (isTargetClear(targetLocation) == player.getColour()) {
                            // illegal move
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
                     }
                 }

                 else {
                     // illegal move
                 }   
        }
        
        else {
            // illegal move
        }
    }
}