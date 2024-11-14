// Ariel Lancer 206550030


import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The Block class.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private static double threshold = Math.pow(10, -10);
    private List<HitListener> hitListeners = new ArrayList<>();
    private Rectangle block;
    private Color color = Color.lightGray;

    /**
     * C-tor of Block class.
     *
     * @param upperPoint
     * @param width
     * @param height
     */
    public Block(Point upperPoint, Double width, Double height) {
        block = new Rectangle(upperPoint, width, height);
    }

    /**
     * Sets the color of the block.
     *
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
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
     * The method draws the block on a given surface.
     *
     * @param surface - surface that the ball is drawn on
     */

    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) block.getUpperLeft().getX(), (int) block.getUpperLeft().getY(),
                (int) block.getWidth(), (int) block.getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) block.getUpperLeft().getX(), (int) block.getUpperLeft().getY(),
                (int) block.getWidth(), (int) block.getHeight());
    }

    /**
     * The method notify the block that time has passed.
     */

    @Override
    public void timePassed() {
        return;
    }

    /**
     * Adds the block to a Game.
     *
     * @param game
     */
    public void addToGame(GameLevel game) {
        game.getGameEnvironment().addCollidable(this);
        game.getSpriteCollection().addSprite(this);
    }

    /**
     * @return Return the "collision shape" of the object.
     */
    public Rectangle getCollisionRectangle() {
        return block;
    }
    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * @param hitter
     * @param collisionPoint
     * @param currentVelocity
     * @return The return is the new velocity expected after the hit (based on
     *      the force the object inflicted on us).
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity v;
        if (checkIfBetween(block.getBottomLeft(), collisionPoint, block.getBottomRight())
                || checkIfBetween(block.getUpperLeft(), collisionPoint, block.getUpperRight())) {
            v = new Velocity(currentVelocity.getDx(), -(currentVelocity.getDy()));
            this.notifyHit(hitter);
            return v;
        }
        v = new Velocity(-(currentVelocity.getDx()), currentVelocity.getDy());
        this.notifyHit(hitter);
        return v;

    }

    /**
     * Removes this block from the given game.
     *
     * @param game
     */

    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     * Adds the HitListener object to the list of listeners.
     *
     * @param hl
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * Removes the given listener from the list.
     *
     * @param hl
     */
    @Override
    public void removeHitListener(HitListener hl) {
        for (HitListener hitListener : hitListeners) {
            if (hitListener.equals(hl)) {
                hitListeners.remove(hitListener);
            }
        }

    }

    /**
     * Notifies all the listeners from the lust that a hit happened,
     * and send them the block that got hit and the ball.
     *
     * @param hitter
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

}
