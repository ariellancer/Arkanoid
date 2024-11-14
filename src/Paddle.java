// Ariel Lancer 206550030


import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * Paddle class.
 */
public class Paddle implements Sprite, Collidable {
    private static int blocksHeight = 30;
    private biuoop.KeyboardSensor keyboard;
    private static double threshold = Math.pow(10, -10);
    private Color color = Color.red;
    private Rectangle paddle;
    private double frameWidth, frameHeight;
    private int speed;

    /**
     * C-tor of Paddle class.
     *
     * @param upperPoint
     * @param width
     * @param height
     * @param keyboard
     */
    public Paddle(Point upperPoint, Double width, Double height, KeyboardSensor keyboard) {
        paddle = new Rectangle(upperPoint, width, height);
        this.keyboard = keyboard;
        this.speed=5;
    }

    /**
     * Sets the frame where the paddle moves to.
     *
     * @param width
     * @param height
     */
    public void setFrame(double width, double height) {
        this.frameHeight = height;
        this.frameWidth = width;
    }

    /**
     * Sets the speed of the paddle.
     * @param speed
     */
    public void setSpeed(int speed){
        this.speed=speed;
    }


    /**
     * Moves the paddle to the left.
     */
    public void moveLeft() {
        if (paddle.getUpperLeft().getX() - speed < blocksHeight) {
            return;
        }
        Point newPoint = new Point(paddle.getUpperLeft().getX() - speed, paddle.getUpperLeft().getY());
        paddle.setUpperLeft(newPoint);
    }

    /**
     * Moves the paddle to the right.
     */
    public void moveRight() {
        if (paddle.getUpperRight().getX() + 5 > frameWidth) {
            return;
        }
        Point newPoint = new Point(paddle.getUpperLeft().getX() + 5, paddle.getUpperLeft().getY());
        paddle.setUpperLeft(newPoint);
    }

    /**
     * notify the paddle that time has passed.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }

    }

    /**
     * draw the paddle to the screen.
     *
     * @param d
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) paddle.getUpperLeft().getX(), (int) paddle.getUpperLeft().getY(),
                (int) paddle.getWidth(), (int) paddle.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) paddle.getUpperLeft().getX(), (int) paddle.getUpperLeft().getY(),
                (int) paddle.getWidth(), (int) paddle.getHeight());
    }

    /**
     * @return Return the "collision shape" of the object.
     */
    public Rectangle getCollisionRectangle() {
        return paddle;
    }

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
        if (check - start.distance(end) < threshold) {
            return true;
        }
        return false;
    }
    /**
     * Notify the object that we collided with it at collisionPoint with
     *       a given velocity.
     * @param hitter
     * @param collisionPoint
     * @param currentVelocity
     * @return The return is the new velocity expected after the hit (based on
     *       the force the object inflicted on us).
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity v = null;
        double dif = this.paddle.getWidth() / 5;
        Point firstPoint, secPoint, thirdPoint, forthPoint, fifthPoint, endPoint;
        firstPoint = this.paddle.getUpperLeft();
        secPoint = new Point(firstPoint.getX() + dif, firstPoint.getY());
        thirdPoint = new Point(secPoint.getX() + dif, secPoint.getY());
        forthPoint = new Point(thirdPoint.getX() + dif, thirdPoint.getY());
        fifthPoint = new Point(forthPoint.getX() + dif, forthPoint.getY());
        endPoint = new Point(fifthPoint.getX() + dif, fifthPoint.getY());

        double xStart = this.paddle.getUpperLeft().getX();
        if (checkIfBetween(firstPoint, collisionPoint, paddle.getBottomLeft())
                || checkIfBetween(endPoint, collisionPoint, paddle.getBottomRight())) {
            v = new Velocity(-(currentVelocity.getDx()), currentVelocity.getDy());
        }

        if (checkIfBetween(firstPoint, collisionPoint, secPoint)) {
            v = Velocity.fromAngleAndSpeed((-60), 5);
        }
        if (checkIfBetween(secPoint, collisionPoint, thirdPoint)) {
            v = Velocity.fromAngleAndSpeed(-30, 5);
        }

        if (checkIfBetween(thirdPoint, collisionPoint, forthPoint)) {
            v = new Velocity(currentVelocity.getDx(), -(currentVelocity.getDy()));
        }
        if (checkIfBetween(forthPoint, collisionPoint, fifthPoint)) {
            v = Velocity.fromAngleAndSpeed(30, 5);
        }
        if (checkIfBetween(fifthPoint, collisionPoint, endPoint)) {
            v = Velocity.fromAngleAndSpeed(60, 5);
        }
        return v;
    }


    /**
     * Adds the paddle to a Game.
     *
     * @param game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
        game.addCollidable(this);
    }
}