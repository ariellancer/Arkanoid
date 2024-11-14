// Ariel Lancer 206550030


import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.*;

/**
 * CountdownAnimation class.
 */
public class CountdownAnimation implements Animation {
    private double numOfSec;
    private int countFrom, num;
    private SpriteCollection gameScreen;
    boolean running;
    private Sleeper sleeper = new Sleeper();

    /**
     * C-tor of CountdownAnimation.
     *
     * @param numOfSeconds
     * @param countFrom
     * @param gameScreen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSec = numOfSeconds;
        this.num = countFrom;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.running = true;
    }

    /**
     * Do One Frame on the given surface.
     *
     * @param d
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.num == 0) {
            this.running = false;
        }
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.red);
        d.drawText(380, d.getHeight() / 2, "" + num, 32);
        this.sleeper.sleepFor((int) (numOfSec * 1000) / countFrom);
        num--;

    }

    /**
     * Is in charge of stop condition.
     *
     * @return boolean.
     */
    @Override
    public boolean shouldStop() {
        return !running;
    }
}
