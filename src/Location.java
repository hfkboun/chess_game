class Location {
    /**
     * Location Class
     */

    private int x;
    private int y;

    public Location(int x, int y) {
        setLocation(x, y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.toString().equals(obj.toString())) {
            return true;
        }
        return false;
    }

}
