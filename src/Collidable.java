// Ariel Lancer 206550030

/**
 * Collidable interface.
 */
public interface Collidable {
    /**
     * @return Return the "collision shape" of the object.
     */


    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     *@param hitter
     * @param collisionPoint
     * @param currentVelocity
     * @return The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */

    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}