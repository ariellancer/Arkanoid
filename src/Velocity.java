// Ariel Lancer 206550030


/**
 * Velocity class.
 */
public class Velocity {
    private double dx, dy;
    /**
     * The method gets an angel and speed and returns a velocity object
     * with the x and y values accordingly.
     *
     * @param angle - the angle of the movment
     * @param speed - the speed of the movment
     * @return Velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.sin(Math.toRadians(angle)) * speed;
        double dy = -Math.cos(Math.toRadians(angle)) * speed;
        return new Velocity(dx, dy);
    }
    /**
     * C-tor of src.Velocity class.
     *
     * @param dx - how much to move on x axis
     * @param dy - how much to move on y axis
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * @return the velocity on x axis.
     */
    public double getDx() {
        return dx;
    }

    /**
     * @return the velocity on y axis.
     */
    public double getDy() {
        return dy;
    }
    /**
     * The method takes a point with position (x,y) and return a new point
     * with position (x+dx, y+dy).
     *
     * @param p - the position (x,y) that we need th change
     * @return Point.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }
}

