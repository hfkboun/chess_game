class Rook extends ChessPiece {
    /**
     * Rook Class
     */

    public Rook(int x, int y, char c) {
        super(x, y,c );
    }

    @Override
    public boolean isPossible(Location targetLocation) {
        int deltaX = Math.abs(targetLocation.getX() - this.getLocation().getX());
        int deltaY = Math.abs(targetLocation.getY() - this.getLocation().getY());
        if (deltaX == 0 && deltaY !=0 || deltaY == 0 && deltaX != 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public Location[] getPath(Location targetLocation) {
        Location[] path = new Location[8];
        path[0] = this.getLocation();
        if (targetLocation.getX() == this.getLocation().getX()) {
            if ((targetLocation.getY() - this.getLocation().getY()) > 0) {
                int i = this.getLocation().getY();
                int j = 1;
                while (targetLocation.getY() > i) {
                    path[j] = new Location(this.getLocation().getX(), i);
                    i++; j++;
                }
            }
            else {
                int i = this.getLocation().getY();
                int j = 1;
                while (targetLocation.getY() < i) {
                    path[j] = new Location(this.getLocation().getX(), i);
                    i--;
                    j++;
                }
            }
        }
        else {
            if ((targetLocation.getX() - this.getLocation().getX()) > 0) {
                int i = this.getLocation().getX();
                int j = 1;
                while (targetLocation.getX() > i) {
                    path[j] = new Location(i, this.getLocation().getY());
                    i++;
                    j++;
                }
            }
            else {
                int i = this.getLocation().getX();
                int j = 1;
                while (targetLocation.getX() < i) {
                    path[j] = new Location(i, this.getLocation().getY());
                    i--;
                    j++;
                }
            }
        }
        return path;
    }
    @Override
    public String toString() {
        return "Rook";
    }
}
