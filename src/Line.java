// Ariel Lancer 206550030


import java.util.List;

/**
 * Line class.
 */
public class Line {
    private Point startPoint, endPoint;
    private Double slope;
    private static double THRESHOLD = Math.pow(10, -10);

    /**
     * C-tor of src.Line class.
     *
     * @param start - the point were the line begins
     * @param end   - the point were the line ends
     */
    public Line(Point start, Point end) {
        startPoint = start;
        endPoint = end;
        setSlope();
    }

    /**
     * C-tor of src.Line class.
     *
     * @param x1 - The value of x in one point
     * @param y1 - The value of y in one point
     * @param x2 - The value of x in second point
     * @param y2 - The value of x in second point
     */
    public Line(double x1, double y1, double x2, double y2) {

        startPoint = new Point(x1, y1);
        endPoint = new Point(x2, y2);
        setSlope();

    }

    /**
     * Return the length of the line.
     *
     * @return length of the line
     */
    public double length() {

        return startPoint.distance(endPoint);
    }

    /**
     * The method calculates the middle point of the line
     * and returns the middle point.
     *
     * @return the middle point
     */
    public Point middle() {
        double middleX;
        double middleY;
        if (startPoint.getX() <= endPoint.getX()) {
            middleX = ((endPoint.getX() - startPoint.getX()) / 2) + startPoint.getX();
            middleY = ((endPoint.getY() - startPoint.getY()) / 2) + startPoint.getY();
        } else {
            middleX = ((startPoint.getX() - endPoint.getX()) / 2) + endPoint.getX();
            middleY = ((startPoint.getY() - endPoint.getY()) / 2) + endPoint.getY();
        }
        return new Point(middleX, middleY);
    }

    /**
     * Returns the start point of the line.
     *
     * @return start point of the line.
     */
    public Point start() {
        return startPoint;
    }

    /**
     * Returns the end point of the line.
     *
     * @return end point of the line.
     */
    public Point end() {

        return endPoint;
    }

    /**
     * The method calculates the intersection with Y-axis.
     *
     * @return Returns the y value of the intersection point
     * with Y axis.
     */
    private Double intersectionWithYAxis() {
        if (slope == null) {
            return null;
        } else {
            return (startPoint.getY() - (slope * startPoint.getX()));
        }
    }

    /**
     * ********** GETTERS AND SETTERS ***********
     **/
    private void setSlope() {
        if (endPoint.getX() == startPoint.getX()) {
            slope = null;
        } else {
            slope = ((startPoint.getY() - endPoint.getY()) / (startPoint.getX() - endPoint.getX()));
        }
    }

    public Double getSlope() {
        return slope;
    }

    public Double getIntersectionWithYAxis() {
        return intersectionWithYAxis();
    }
/** *********** END GETTERS AND SETTERS *********** **/


    /**
     * Checks if a point is between tow other points.
     *
     * @param start   the first point of the two points
     * @param between the point to check if is between the tow other
     * @param end     the second point of the tow points
     * @return Returns true if the point is between
     * else returns false
     */
    private boolean checkIfBetween(Point start, Point between, Point end) {
        double check;
        check = start.distance(between) + between.distance(end);
        if (check - start.distance(end) < THRESHOLD) {
            return true;
        }
        return false;
    }

    /**
     * The method checks if a line that is aligned with Y axis
     * has an intersection point with another line.
     *
     * @param alignedWithY
     * @param other
     * @return Returns true if the lines intersect and false if not
     */
    private boolean checkIntersectionIfAlignedWithYAxis(Line alignedWithY, Line other) {
        Point between;
        double newX, newY;
        newX = alignedWithY.startPoint.getX();
        newY = (other.getSlope() * newX) + other.getIntersectionWithYAxis();
        between = new Point(newX, newY);
        if (checkIfBetween(alignedWithY.startPoint, between, alignedWithY.endPoint)
                && checkIfBetween(other.startPoint, between, other.endPoint)) {
            return true;
        }
        return false;
    }

    /**
     * Returns true if the lines intersect, false otherwise.
     *
     * @param other the line to check intersection with
     * @return Returns true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        Point between;
        double newX, newY;
        if (this.getSlope() == other.getSlope()) {
            if (checkIfBetween(this.startPoint, other.startPoint, this.endPoint)
                    || checkIfBetween(this.startPoint, other.endPoint, this.endPoint)) {
                return true;
            }
            return false;
        } else {
            if (this.getIntersectionWithYAxis() == null || other.getIntersectionWithYAxis() == null) {
                if (this.getIntersectionWithYAxis() == null) {
                    return checkIntersectionIfAlignedWithYAxis(this, other);
                }
                if (other.getIntersectionWithYAxis() == null) {
                    return checkIntersectionIfAlignedWithYAxis(other, this);
                }

            }
            newX = (this.getIntersectionWithYAxis() - other.getIntersectionWithYAxis())
                    / (other.getSlope() - this.getSlope());
            newY = (this.getSlope() * newX) + this.getIntersectionWithYAxis();
            between = new Point(newX, newY);
            if (checkIfBetween(this.startPoint, between, this.endPoint)
                    && checkIfBetween(other.startPoint, between, other.endPoint)) {
                return true;
            }
            return false;
        }
    }


    /**
     * The method calculates the intersection point of this line
     * with another line given to the method.
     *
     * @param other the line that we want to get the
     *              intersection point with
     * @return Returns the intersection point if the lines intersect,
     * and null otherwise.
     */
    public Point intersectionWith(Line other) {
        double newX, newY;
        if (!isIntersecting(other)) {
            return null;
        }
        if (this.getSlope() == other.getSlope()) {
            if (this.start().getX() == other.end().getX()) {
                return this.start();
            }
            if (this.end().getX() == other.start().getX()) {
                return this.end();
            }
            return null;
        }
        if (this.getIntersectionWithYAxis() == null) {
            newX = this.startPoint.getX();
            newY = (other.getSlope() * newX) + other.getIntersectionWithYAxis();
            return new Point(newX, newY);
        }
        if (other.getIntersectionWithYAxis() == null) {
            newX = other.startPoint.getX();
            newY = (this.getSlope() * newX) + this.getIntersectionWithYAxis();
            return new Point(newX, newY);
        }
        newX = (this.getIntersectionWithYAxis()
                - other.getIntersectionWithYAxis()) / (other.getSlope() - this.getSlope());
        newY = (this.getSlope() * newX) + this.getIntersectionWithYAxis();
        return new Point(newX, newY);
    }

    /**
     * Checks if the lines are equal.
     *
     * @param other
     * @return Return true is the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        if (this.start() == other.start() && this.end() == other.end()) {
            return true;
        }
        return false;
    }

    /**
     * The method calculates the closest intersection point to the
     * start of the line.
     *
     * @param rect
     * @return If this line does not intersect with the rectangle, return null.
     * *    Otherwise, return the closest intersection point to the
     * *    start of the line.
     */

    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        int i = 0;
        Point closestPoint, check;
        List<Point> list = rect.intersectionPoints(this);

        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            closestPoint = new Point(list.get(i).getX(), list.get(i).getY());
            return closestPoint;
        }
        closestPoint = new Point(list.get(i).getX(), list.get(i).getY());
        check = new Point(list.get(i + 1).getX(), list.get(i + 1).getY());
        if (startPoint.distance(closestPoint) > startPoint.distance(check)) {
            return check;
        }
        return closestPoint;
    }

}
