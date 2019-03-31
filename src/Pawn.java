class Pawn extends ChessPiece {
    /**
     * Pawn Class
     */
    
    private boolean firstMoveCheck;
     
    public Pawn(int x, int y, char c) {
        super(x, y, c);
        this.firstMoveCheck = true;
    }

    @Override // ensure no back moves possible (maybe two different )
    public boolean isPossible(Location targetLocation) {
        int deltaX = Math.abs(targetLocation.getX() - this.getLocation().getX());
        int deltaY = targetLocation.getY() - this.getLocation().getY();
        
        if (this.colour == 'w') {
            if (this.firstMoveCheck) {
                if (deltaX <= 1 && deltaY <= 2 && deltaY != 0) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                if (deltaX <= 1 && deltaY <= 1 && deltaY != 0) {
                    return true;
                }
                else {
                    return false;
                }
            } 
        }
        else {
            if (this.firstMoveCheck) {
                if (deltaX <= 1 && deltaY >= -2 && deltaY != 0) {
                    return true;
                }
                else {
                    return false;
                }
            } else {
                if (deltaX <= 1 && deltaY >= -1 && deltaY != 0) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
    }
    
    @Override
    public Location[] getPath(Location targetLocation) {
        Location[] path = new Location[10];
        path[0] = this.getLocation();
        // todo
        return path;
    }
    public boolean isFirstMoveCheck() {
        return this.firstMoveCheck;
    }

    public void setFirstMoveCheck(){
        this.firstMoveCheck = false;
    }
}
