public abstract class ChessPiece {
    /**
     * ChessPiece Class
     */

    protected Location location = new Location(0, 0);
    protected int status;
    protected char colour;

    protected ChessPiece(int x, int y, char c) {
        this.location.setLocation(x, y);
        this.status = 1;
        this.colour = c;
    }
    
	protected boolean isPossible(Location targetLocation) {
		return true;
		// override
    }
    
    protected Location[] getPath(Location targetLocation) {
        Location[] path = new Location[8];
        path[0] = this.getLocation();
        return path;
        // override
    }

    protected void kill() {
        this.status = 0;
    }

    protected int getStatus() {
        return this.status;
    }

    protected Location getLocation() {
        return this.location;
    }

    protected void setLocation(Location location) {
        this.location = location;
    }

    protected char getPieceColour() {
        return this.colour;
    }
}
