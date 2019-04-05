import java.util.ArrayList;
import java.util.HashMap;

class Board {
    /**
     * Board Class
     */

    private int counter = 0;

    Player white;
    Player black;
    HashMap<String, String> boardArrayForDisplay = new HashMap<String, String>();

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
        if (path.length == 1) {
            return true;
        }
        else {
            ChessPiece[] allPieces = getAllPiecesInBoard();
            for (ChessPiece tempPiece : allPieces) {
                for (Location tempLocation : path) { // path.doluElemanlar()
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
            // 
            if (Math.abs(targetLocation.getX() - player.getPieceFromString(piece).getLocation().getX()) == 1) {
                if (isTargetClear(targetLocation) == '0') {
                    // illegal move
                }
                else {
                    this.move(player, piece, targetLocation);
                }
            }
            else {
                this.move(player, piece, targetLocation);
            }
        }
    }



    // pawn's firstMove should change to 1
    public void move(Player player, String piece, Location targetLocation) throws Exception {
        System.out.println("1");
        // if the turn is the player's, continue
        if ((counter % 2 == 0 && player.getColour() == 'w') || (counter % 2 == 1 && player.getColour() == 'b')) {
            System.out.println("2");
            // if the move is legal for the piece
            if (player.getPieceFromString(piece).isPossible(targetLocation)) {
                System.out.println("3");
                // if there is no obstacles, continue
                if (isPathClear(player.getPieceFromString(piece).getPath(targetLocation))) {
                    System.out.println("4");
                    // if target is same colour, error
                    if (isTargetClear(targetLocation) == player.getColour()) {
                        // illegal move
                        throw new Exception("targetIsSameColour");
                    }
                        
                    // if target is different colour, kill piece
                    else if (isTargetClear(targetLocation) != player.getColour() && isTargetClear(targetLocation) != '0') {
                        getEnemyPieceFromLocation(player.getColour(), targetLocation).kill();
                        counter++;
                        System.out.println("5");
                    }
                       
                    // if target is empty, move
                    else {
                        player.getPieceFromString(piece).setLocation(targetLocation); // set location
                        counter++;
                        System.out.println("6");
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

    public void display() {
        // Update Array
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardArrayForDisplay.put(new Location(i, j).toString(), " ");
            }
        }
        for (ChessPiece tempPiece : getAllPiecesInBoard()) {
            boardArrayForDisplay.put(tempPiece.getLocation().toString(), tempPiece.toString());
        }
        // Print Array
        System.out.println("--- BOARD ---\n");
        System.out.printf("%10s%10s%10s%10s%10s%10s%10s%10s\n", "1     ", "2     ", "3     ", "4     ", "5     ", "6     ", "7     ", "8     \n");
        for (int i = 0; i < 8; i++) {
            System.out.printf("%-3c", (char) i + 65);
            for (int j = 0; j < 8; j++) {
                    System.out.printf("%-10s", boardArrayForDisplay.get(new Location(i, j).toString()));
            }    
            System.out.println();
        }
    }
}
