import java.util.ArrayList;

class Player {
    /**
     * Player Class
     */

	private char colour;
	
    King king;
    Queen queen;
	
	Rook rook1;
    Rook rook2;

    Knight knight1;
    Knight knight2;

    Bishop bishop1;
    Bishop bishop2;

	Pawn pawn1;
    Pawn pawn2;
	Pawn pawn3;
	Pawn pawn4;
	Pawn pawn5;
	Pawn pawn6;
	Pawn pawn7;
	Pawn pawn8;

	ChessPiece[] pieces = {king, queen, 
                rook1, rook2, 
                knight1, knight2, 
                bishop1, bishop2, 
                pawn1, pawn2, pawn3, pawn4, pawn5, pawn6, pawn7, pawn8};

    public Player(char colour) {
		this.colour = colour;
		
        if (colour == 'w') {
            king = new King(0, 4);
            queen = new Queen(0, 3);

            rook1 = new Rook(0, 0);
            rook2 = new Rook(0, 7);

            knight1 = new Knight(0, 1);
            knight2 = new Knight(0, 6);

            bishop1 = new Bishop(0, 2);
            bishop2 = new Bishop(0, 5);

           	pawn1 = new Pawn(1, 0);
            pawn2 = new Pawn(1, 1);
            pawn3 = new Pawn(1, 2);
            pawn4 = new Pawn(1, 3);
            pawn5 = new Pawn(1, 4);
            pawn6 = new Pawn(1, 5);
            pawn7 = new Pawn(1, 6);
            pawn8 = new Pawn(1, 7);
        }
        else if (colour == 'b') {
            king = new King(7, 4);
            queen = new Queen(7, 3);

            rook1 = new Rook(7, 7);
            rook2 = new Rook(7, 0);

            knight1 = new Knight(7, 6);
            knight2 = new Knight(7, 1);

            bishop1 = new Bishop(7, 5);
            bishop2 = new Bishop(7, 2);

            pawn1 = new Pawn(6, 0);
            pawn2 = new Pawn(6, 1);
            pawn3 = new Pawn(6, 2);
            pawn4 = new Pawn(6, 3);
            pawn5 = new Pawn(6, 4);
            pawn6 = new Pawn(6, 5);
            pawn7 = new Pawn(6, 6);
			pawn8 = new Pawn(6, 7);
        }
    }

    public char getColour() {
        return this.colour;
	}
	
	public ChessPiece getPieceFromLocation(Location loc) {
        for (int i = 0; i < 16; i++) {
			if (loc.equals(pieces[i].getLocation())) {
				return pieces[i];
			}
        }
        return null;
	}

    public ChessPiece getPieceFromString(String str) {
		switch (str) {
			case "king":
				return king;
			case "queen":
				return queen;
			case "rook1":
				return rook1;
			case "rook2":
				return rook2;
			case "knight1":
				return knight1;
			case "knight2":
				return knight2;
			case "bishop1":
				return bishop1;
			case "pawn1":
				return pawn1;
			case "pawn2":
				return pawn2;
			case "pawn3":
				return pawn3;
			case "pawn4":
				return pawn4;
			case "pawn5":
				return pawn5;
			case "pawn6":
				return pawn6;
			case "pawn7":
				return pawn7;
			case "pawn8":
				return pawn8;
			default:
				return null;
		}  
	}
	
	public ChessPiece[] getAllPiecesInPlayer() {
		
		ArrayList<ChessPiece> temporary = new ArrayList<ChessPiece>();
		for (int i = 0; i < 16; i++) {
			if (pieces[i].getStatus() == 1) {
				temporary.add(pieces[i]); 
			}
		}
		
		ChessPiece[] alivePieces = new ChessPiece[temporary.size()];
		alivePieces = temporary.toArray(alivePieces);
        return alivePieces;
	}
}
