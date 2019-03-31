class Bishop extends ChessPiece {
    /** 
     * Bishop Class
     */
    
    public Bishop(int x, int y, char c) {
        super(x, y,c);
    }

    @Override
    public boolean isPossible(Location targetLocation) {
        int deltaX = Math.abs(targetLocation.getX() - this.getLocation().getX());
        int deltaY = Math.abs(targetLocation.getY() - this.getLocation().getY());
        if (deltaX == deltaY) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Location[] getPath(Location targetLocation) {
        Location[] path = new Location[10];
        path[0] = this.getLocation();
        // todo
        return path;
    }
}
