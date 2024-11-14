// Ariel Lancer 206550030

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * SpriteCollection class.
 */
public class SpriteCollection {
    private List<Sprite> listOfSprites = new ArrayList<>();

    /**
     * Adds the given Sprite to the collection.
     * @param s
     */
    public void addSprite(Sprite s) {
        listOfSprites.add(s);
    }

    /**
     * Removes the given Sprite from the collection.
     * @param s
     */
    public void removeSprite(Sprite s) {
        listOfSprites.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */

    public void notifyAllTimePassed() {
        for (int i = 0; i < listOfSprites.toArray().length; i++) {
            listOfSprites.get(i).timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     * @param d
     */

    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < listOfSprites.toArray().length; i++) {
            listOfSprites.get(i).drawOn(d);
        }
    }
}
