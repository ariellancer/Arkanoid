// Ariel Lancer 206550030


import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * PauseScreen class.
 */
public class PauseScreen implements Animation {
    private boolean stop;

    /**
     * C-tor of PauseScreen.
     */
    public PauseScreen() {
        this.stop = false;
    }

    /**
     * Do One Frame on the given surface.
     *
     * @param d
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);

    }

    /**
     * Is in charge of stop condition.
     *
     * @return boolean.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
