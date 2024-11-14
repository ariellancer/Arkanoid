// Ariel Lancer 206550030


import java.util.ArrayList;
import java.util.List;

/**
 * GameEnvironment class.
 */
public class GameEnvironment {
    private List<Collidable> list = new ArrayList<>();

    /**
     * add the given collidable to the environment.
     *
     * @param c
     */

    public void addCollidable(Collidable c) {
        list.add(c);
    }

    /**
     * Removes the given collidable from the environment.
     *
     * @param c
     */
    public void removeCollidable(Collidable c) {
        list.remove(c);
    }

    /**
     * The method checks If this object will or will not collide with any
     * of the collidables in this collection.
     *
     * @param line
     * @return If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     */

    private CollisionInfo checkClosestCollision(Line line) {
        CollisionInfo info;
        Collidable shape;
        int j = 0;
        Point collisionPoint, check;

        shape = list.get(j);
        collisionPoint = line.closestIntersectionToStartOfLine(list.get(j).getCollisionRectangle());
        for (int i = 1; i < list.toArray().length; i++) {
            check = line.closestIntersectionToStartOfLine(list.get(i).getCollisionRectangle());
            if (collisionPoint == null) {
                collisionPoint = check;
                shape = list.get(i);
                continue;
            }
            if (check == null) {
                continue;
            }
            if (line.start().distance(collisionPoint) > line.start().distance(check)) {
                collisionPoint = check;
                shape = list.get(i);
            }

        }
        info = new CollisionInfo(shape, collisionPoint);
        return info;
    }


    /**
     * @param trajectory
     * @return If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        return checkClosestCollision(trajectory);
    }

}