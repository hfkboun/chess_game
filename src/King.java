class King extends ChessPiece {
    /**
     * King Class
     */

    public King(int x, int y, char c) {
        super(x, y, c);
    }

    @Override
    public boolean isPossible(Location targetLocation) {
        // checks if the move is a move the piece naturally can do
        int deltaX = Math.abs(targetLocation.getX() - this.getLocation().getX());
        int deltaY = Math.abs(targetLocation.getY() - this.getLocation().getY());
        if (deltaX <= 1 && deltaY <= 1) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Location[] getPath(Location targetLocation) {  
        return new Location[1]; // return empty Location Array
    }

    @Override
    public String toString() {
        return "King";
    } 
}
