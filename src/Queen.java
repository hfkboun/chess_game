class Queen extends ChessPiece {
    /**
     * Queen Class
     */

    public Queen(int x, int y, char c) {
        super(x, y, c);
    }

    @Override
    public boolean isPossible(Location targetLocation) {
        int deltaX = Math.abs(targetLocation.getX() - this.getLocation().getX());
        int deltaY = Math.abs(targetLocation.getY() - this.getLocation().getY());
        if (deltaX == 0 && deltaY !=0 || deltaY == 0 && deltaX != 0) {
            return true;
        }
        else if (deltaX == deltaY) {
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
        if (targetLocation.getX() == this.getLocation().getX() || targetLocation.getY() == this.getLocation().getY()) {
            if (targetLocation.getX() == this.getLocation().getX()) {
                if ((targetLocation.getY() - this.getLocation().getY()) > 0) {
                    int i = this.getLocation().getY();
                    int j = 1;
                    while (targetLocation.getY() > i) {
                        path[j] = new Location(this.getLocation().getX(), i);
                        i++;
                        j++;
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
        }
        else {
            if ((targetLocation.getX() - this.getLocation().getX()) > 0) {
                if ((targetLocation.getY() - this.getLocation().getY()) > 0) {
                    // top right
                    int i = this.getLocation().getX();
                    int j = this.getLocation().getY();
                    int k = 1;
                    while (targetLocation.getX() > i) {
                        path[k] = new Location(i, j);
                        i++;
                        j++;
                    }
                }
                else {
                    // bottom right
                    int i = this.getLocation().getX();
                    int j = this.getLocation().getY();
                    int k = 1;
                    while (targetLocation.getX() > i) {
                        path[k] = new Location(i, j);
                        i++;
                        j--;
                    }
                }
            } else {
                if ((targetLocation.getY() - this.getLocation().getY()) > 0) {
                    // top left
                    int i = this.getLocation().getX();
                    int j = this.getLocation().getY();
                    int k = 1;
                    while (targetLocation.getX() < i) {
                        path[k] = new Location(i, j);
                        i--;
                        j++;
                    }
                }
                else {
                    // bottom left
                    int i = this.getLocation().getX();
                    int j = this.getLocation().getY();
                    int k = 1;
                    while (targetLocation.getX() < i) {
                        path[k] = new Location(i, j);
                        i--;
                        j--;
                    }
                }
            }
        }
        return path;
    }

    @Override
    public String toString() {
        return getPieceColour()+"Queen";
    } 
}
