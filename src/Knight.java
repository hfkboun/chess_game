class Knight extends ChessPiece {
    /**
     * Knight Class
     */

    public Knight(int x, int y, char c) {
        super(x, y, c);
    }

    @Override
    public boolean isPossible(Location targetLocation) {
        int deltaX = Math.abs(targetLocation.getX() - this.getLocation().getX());
        int deltaY = Math.abs(targetLocation.getY() - this.getLocation().getY());

        if (deltaX == 2 && deltaY == 1 || deltaX == 1 && deltaY == 2) {
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
        return getPieceColour()+"Knight";
    }
}
