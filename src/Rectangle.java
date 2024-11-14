// Ariel Lancer 206550030


import java.util.ArrayList;
import java.util.List;

/**
 * Rectangle class.
 */
public class Rectangle {
    private int numOfSides = 4;
    private Point upperLeft, upperRight, bottomLeft, bottomRight;
    private double width, height;
    private Line upperLine, bottomLine, leftLine, rightLine;

    /**
     * C-tor of Rectangle class,
     * Creates a new rectangle with location and width/height.
     * and sets its points and lines
     *
     * @param upperLeft
     * @param width
     * @param height
     */

    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        setPoints(upperLeft, width, height);
    }

    /**
     * The method calculates the intersection points of
     * the line with the Rectangle.
     *
     * @param line
     * @return Return a (possibly empty) List of intersection points
     * with the specified line.
     */

    public List<Point> intersectionPoints(Line line) {
        List<Point> list = new ArrayList<Point>();
        list.add(line.intersectionWith(this.getUpperLine()));
        list.add(line.intersectionWith(this.getLeftLine()));
        list.add(line.intersectionWith(this.getBottomLine()));
        list.add(line.intersectionWith(this.getRightLine()));
        while (list.remove(null));
        return list;
    }

    /**
     * ********** GETTERS AND SETTERS ***********
     **/

    /**
     * @return Return the width and height of the rectangle
     */

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    /**
     * @return Return the points of the rectangle
     */
    public Point getBottomRight() {
        return bottomRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public Point getUpperRight() {
        return upperRight;
    }

    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * @return Return the lines of the rectangle
     */
    public Line getUpperLine() {
        return this.upperLine;
    }

    public Line getBottomLine() {
        return this.bottomLine;
    }

    public Line getLeftLine() {
        return this.leftLine;
    }

    public Line getRightLine() {
        return this.rightLine;
    }

    /**
     * Sets the upperLeft point of the rectangle.
     *
     * @param point
     */
    public void setUpperLeft(Point point) {
        this.upperLeft = point;
        setPoints(point, this.width, this.height);
    }

    /**
     * Sets the points and the lines of the rectangle.
     *
     * @param upperLeft
     * @param width
     * @param height
     */
    private void setPoints(Point upperLeft, double width, double height) {
        upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        bottomLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        bottomRight = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        setLines(upperLeft, upperRight, bottomLeft, bottomRight);
    }

    private void setLines(Point upperLeft, Point upperRight, Point bottomLeft, Point bottomRight) {
        upperLine = new Line(upperLeft, upperRight);
        leftLine = new Line(upperLeft, bottomLeft);
        bottomLine = new Line(bottomLeft, bottomRight);
        rightLine = new Line(upperRight, bottomRight);
    }

    /** *********** END GETTERS AND SETTERS *********** **/

}
