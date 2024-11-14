// Ariel Lancer 206550030


/**
 * Point class.
 */
public class Point {
    private double x;
    private double y;

    /**
     * C-tor of src.Point class.
     *
     * @param x - the x value of the point
     * @param y - the y value of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * return the distance of this point to the other point.
     *
     * @param other the point to check the distance from
     * @return the distance of this point to the other point.
     */
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.getX()) * (this.x - other.getX()))
                + ((this.y - other.getY()) * (this.y - other.getY())));
    }

    /**
     * return true is the points are equal, false otherwise.
     *
     * @param other - the point to check if is equal.
     * @return true is the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        if ((this.x == other.getX()) && (this.y == other.getY())) {
            return true;
        }
        return false;
    }

    /**
     * Return the x values of this point.
     *
     * @return the x values of this point.
     */
    public double getX() {
        return this.x;
    }
    /**
     * Return the y values of this point.
     *
     * @return the y values of this point.
     */
    public double getY() {
        return this.y;
    }
}
