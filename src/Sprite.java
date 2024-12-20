// Ariel Lancer 206550030



import biuoop.DrawSurface;

/**
 * Sprite interface.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     * @param d
     */

    void drawOn(DrawSurface d);

    /**
     *  notify the sprite that time has passed.
     */

    void timePassed();
}
