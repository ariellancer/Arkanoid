// Ariel Lancer 206550030

import biuoop.DrawSurface;

/**
 * The Animation interface.
 */

public interface Animation {
    /**
     * Do One Frame on the given surface.
     * @param d
     */
    void doOneFrame(DrawSurface d);

    /**
     * Checks if to stop tha Animation.
     * @return
     */
    boolean shouldStop();
}
