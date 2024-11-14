// Ariel Lancer 206550030

/**
 * Collision info class.
 */
public class CollisionInfo {
     private Collidable shape;
     private Point collisionPoint;

    /**
     * C-tor of CollisionInfo class.
     *
     * @param shape
     * @param collisionPoint
     */

    public CollisionInfo(Collidable shape, Point collisionPoint) {
        this.shape = shape;
        this.collisionPoint = collisionPoint;
    }

    /**
     * @return Returns the collision point.
     */
    public Point CollisionPoint() {
        return this.collisionPoint;

    }

    /**
     * @return The collidable object involved in the collision.
     */

    public Collidable collisionObject() {
        return this.shape;
    }
}