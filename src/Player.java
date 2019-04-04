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

	ChessPiece[] pieces = new ChessPiece[16];

    public Player(char colour) {
		this.colour = colour;
		
        if (colour == 'w') {
            king = new King(4, 0, 'w');
            queen = new Queen(3, 0, 'w');

            rook1 = new Rook(0, 0, 'w');
            rook2 = new Rook(7, 0, 'w');

            knight1 = new Knight(1, 0, 'w');
            knight2 = new Knight(6, 0, 'w');

            bishop1 = new Bishop(2, 0, 'w');
            bishop2 = new Bishop(5, 0, 'w');

           	pawn1 = new Pawn(0, 1, 'w');
            pawn2 = new Pawn(1, 1, 'w');
            pawn3 = new Pawn(2, 1, 'w');
            pawn4 = new Pawn(3, 1, 'w');
            pawn5 = new Pawn(4, 1, 'w');
            pawn6 = new Pawn(5, 1, 'w');
            pawn7 = new Pawn(6, 1, 'w');
			pawn8 = new Pawn(7, 1, 'w');			
        }
        else if (colour == 'b') {
            king = new King(4, 7, 'b');
            queen = new Queen(3, 7, 'b');

            rook1 = new Rook(7, 7, 'b');
            rook2 = new Rook(0, 7, 'b');

            knight1 = new Knight(6, 7, 'b');
            knight2 = new Knight(1, 7, 'b');

            bishop1 = new Bishop(5, 7, 'b');
            bishop2 = new Bishop(2, 7, 'b');

            pawn1 = new Pawn(0, 6, 'b');
            pawn2 = new Pawn(1, 6, 'b');
            pawn3 = new Pawn(2, 6, 'b');
            pawn4 = new Pawn(3, 6, 'b');
            pawn5 = new Pawn(4, 6, 'b');
            pawn6 = new Pawn(5, 6, 'b');
            pawn7 = new Pawn(6, 6, 'b');
			pawn8 = new Pawn(7, 6, 'b');
		}
			
		pieces[0] = king;
		pieces[1] = queen;
		pieces[2] = rook1;
		pieces[3] = rook2;
		pieces[4] = knight1;
		pieces[5] = knight2;
		pieces[6] = bishop1;
		pieces[7] = bishop2;
		pieces[8] = pawn1;
		pieces[9] = pawn2;
		pieces[10] = pawn3;
		pieces[11] = pawn4;
		pieces[12] = pawn5;
		pieces[13] = pawn6;
		pieces[14] = pawn7;
		pieces[15] = pawn8;
    }

    public char getColour() {
        return this.colour;
	}
	
	public ChessPiece getPieceFromLocation(Location loc) {
        for (int i = 0; i < 16; i++) {
			// System.out.println(pieces[i]);
			if (loc.equals(pieces[i].getLocation())) {
				if (pieces[i].getStatus() == 1) return pieces[i];
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
