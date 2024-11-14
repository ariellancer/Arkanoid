// Ariel Lancer 206550030

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Ball class.
 */
public class Ball implements Sprite {
    private static int defaultFrameSize = 400;
    private static int defaultFrameStart = 0;
    private static double threshold = Math.pow(10, -10);
    private GameEnvironment game = new GameEnvironment();
    private Point center;
    private int radius,
            boardStartX = defaultFrameStart, boardStartY = defaultFrameStart,
            boardWidth = defaultFrameSize, boardHeight = defaultFrameSize;
    private Velocity v = null;
    private Color color;

    /**
     * C-tor of src.Ball class.
     * @param center - the center point of the ball
     * @param r      radius of ball
     * @param color  the color of the ball
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
    }
    /**
     * C-tor of src.Ball class.
     * @param x     - the x value of the center point of the ball
     * @param y     - the y value of the center point of the ball
     * @param r     - radius of ball
     * @param color - the color of the ball
     */
    public Ball(int x, int y, int r, Color color) {
        this.center = new Point(x, y);
        this.radius = r;
        this.color = color;
    }

    /**
     * ********** GETTERS AND SETTERS ***********
     **/

    public int getX() {
        return (int) center.getX();
    }

    public int getY() {
        return (int) center.getY();
    }

    public int getSize() {
        return radius;
    }

    public Color getColor() {
        return this.color;
    }

    public Velocity getVelocity() {
        return v;
    }

    public void setVelocity(Velocity v) {
        this.v = new Velocity(v.getDx(), v.getDy());
    }

    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /** *********** END GETTERS AND SETTERS *********** **/

    /**
     * The method draws the ball on a given surface.
     *
     * @param surface - surface that the ball us drawn on
     */

    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) center.getX(), (int) center.getY(), this.radius);
    }

    /**
     * The method notify the ball that time has passed
     * and tells it to move according to the moveOneStep method.
     */
    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * The method updates the coordinates of the frame where ball is drawn on.
     *
     * @param start - The first points coordinates
     * @param end   - The second points coordinates
     */
    public void setFrame(Point start, Point end) {
        this.boardWidth = (int) end.getX();
        this.boardHeight = (int) end.getY();
        this.boardStartX = (int) start.getX();
        this.boardStartY = (int) start.getY();
    }

    /**
     * The method calculates the trajectory of the ball in the
     * case its moving down and left.
     *
     * @param leftSideOfBoard
     * @param boardHeight
     * @return The trajectory
     */

    private Line handleCaseBallGoingDownLeft(int leftSideOfBoard, int boardHeight) {
        Line line;
        Point start, end;
        double xOfCollation, slope, yOfYAxisCollation;

        start = new Point(this.getX(), this.getY());
        slope = (this.getVelocity().getDy() / this.getVelocity().getDx());
        yOfYAxisCollation = start.getY() - (slope * start.getX());
        xOfCollation = (boardHeight - yOfYAxisCollation) / slope;

        if (xOfCollation >= leftSideOfBoard) {
            end = new Point(xOfCollation, boardHeight);
        } else {
            end = new Point(leftSideOfBoard, yOfYAxisCollation);
        }
        line = new Line(start, end);
        return line;
    }


    /**
     * The method calculates the trajectory of the ball in the
     * case its moving down and right.
     *
     * @param boardHeight
     * @param boardWidth
     * @return The trajectory
     */

    private Line handleCaseBallGoingDownRight(int boardHeight, int boardWidth) {
        Line line;
        Point start, end;
        double xOfCollation, yOfYRightSideCollation, slope, yOfYAxisCollation;

        start = new Point(this.getX(), this.getY());
        slope = (this.getVelocity().getDy() / this.getVelocity().getDx());
        yOfYAxisCollation = start.getY() - (slope * start.getX());
        xOfCollation = (boardHeight - yOfYAxisCollation) / slope;
        if (xOfCollation <= boardWidth) {
            end = new Point(xOfCollation, boardHeight);
        } else {
            yOfYRightSideCollation = slope * boardWidth + yOfYAxisCollation;
            end = new Point(boardWidth, yOfYRightSideCollation);
        }
        line = new Line(start, end);
        return line;
    }

    /**
     * The method calculates the trajectory of the ball in the
     * case its moving up and right.
     *
     * @param boardTop
     * @param rightSideX
     * @return The trajectory
     */
    private Line handleCaseBallGoingUpRight(int boardTop, int rightSideX) {
        Line line;
        Point start, end;
        double xOfCollation, yOfYRightSideCollation, slope, yOfYAxisCollation;

        start = new Point(this.getX(), this.getY());
        slope = (this.getVelocity().getDy() / this.getVelocity().getDx());
        yOfYAxisCollation = start.getY() - (slope * start.getX());
        xOfCollation = (boardTop - yOfYAxisCollation) / slope;
        if (xOfCollation <= rightSideX) {
            end = new Point(xOfCollation, boardTop);
        } else {
            yOfYRightSideCollation = slope * rightSideX + yOfYAxisCollation;
            end = new Point(rightSideX, yOfYRightSideCollation);
        }
        line = new Line(start, end);
        return line;
    }

    /**
     * The method calculates the trajectory of the ball in the
     * case its moving up and left.
     *
     * @param boardTop
     * @param leftSideX
     * @return The trajectory
     */
    private Line handleCaseBallGoingUpLeft(int boardTop, int leftSideX) {
        Line line;
        Point start, end;
        double xOfCollation, slope, yOfYAxisCollation;

        start = new Point(this.getX(), this.getY());
        slope = (this.getVelocity().getDy() / this.getVelocity().getDx());
        yOfYAxisCollation = start.getY() - (slope * start.getX());
        xOfCollation = (boardTop - yOfYAxisCollation) / slope;
        if (xOfCollation >= leftSideX) {
            end = new Point(xOfCollation, boardTop);
        } else {
            end = new Point(leftSideX, yOfYAxisCollation);
        }
        line = new Line(start, end);
        return line;
    }

    /**
     * The method calculates the trajectory of the ball in the
     *      * case its moving straight up.
     * @param boardStartY
     * @param boardStartX
     * @return
     */
    private Line handleCaseBallGoingStraight(int boardStartY, int boardStartX) {
        Line line;
        Point start, end;

        start=new Point(this.getX(),this.getY());
        end=new Point(this.getX(),boardStartY);
        line=new Line(start,end);
        return line;
    }

    /**
     * Set the game environment of the ball.
     *
     * @param game
     */
    public void setGame(GameEnvironment game) {
        this.game = game;
    }

    /**
     * Adds the ball to a Game.
     *
     * @param game
     */
    public void addToGame(GameLevel game) {
        game.getSpriteCollection().addSprite(this);
    }


    /**
     * The method moves the ball on the surface according to the velocity.
     */
    public void moveOneStep() {
        Line trajectory = null;
        CollisionInfo info;
        Velocity temp;

        if (this.getVelocity() == null) {
            return;
        }
        if (this.getVelocity().getDx()==0&&this.getVelocity().getDy()!=0){
            trajectory=handleCaseBallGoingStraight(boardStartY,boardStartX);
        }
        if (this.getVelocity().getDx() < 0 && this.getVelocity().getDy() < 0) {
            trajectory = handleCaseBallGoingUpLeft(boardStartY, boardStartX);
        }
        if (this.getVelocity().getDx() > 0 && this.getVelocity().getDy() < 0) {
            trajectory = handleCaseBallGoingUpRight(boardStartY, boardWidth);
        }
        if (this.getVelocity().getDx() > 0 && this.getVelocity().getDy() > 0) {
            trajectory = handleCaseBallGoingDownRight(boardHeight, boardWidth);
        }
        if (this.getVelocity().getDy() > 0 && this.getVelocity().getDx() < 0) {
            trajectory = handleCaseBallGoingDownLeft(boardStartX, boardHeight);
        }

        info = game.getClosestCollision(trajectory);
        if ((Math.abs(info.CollisionPoint().getX() - this.center.getX()) <= radius)
                && Math.abs(info.CollisionPoint().getY() - this.center.getY()) <= radius) {
            temp = info.collisionObject().hit(this, info.CollisionPoint(), this.getVelocity());
            setVelocity(temp);
            this.center = this.getVelocity().applyToPoint(this.center);
            return;
        }
        setVelocity(this.getVelocity().getDx(), this.getVelocity().getDy());
        this.center = this.getVelocity().applyToPoint(this.center);
    }



    /**
     * The method removes the ball from the given game.
     *
     * @param game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}


