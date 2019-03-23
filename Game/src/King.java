class King extends ChessPiece {
    /**
     * King Class
     */

    public King(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isPossible(Location targetLocation) {
        // checks if the move is a move the piece naturally can do
        int deltaX = Math.abs(targetLocation.getX() - this.getLocation().getX());
        int deltaY = Math.abs(targetLocation.getY() - this.getLocation().getY());
        if (deltaX + deltaY <= 2) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Location[] getPath(Location targetLocation) {  
        return null;
    }

}